package client;

import code.ArrayList;
import code.TextWorker;
import code.Toolbars;
import gui.Labels;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import static gui.Labels.FirstMessage;

public class Client extends Application
{
    private static FlowPane flowfixer;
    private static ToolBar horizontalTB = new ToolBar();
    private static BorderPane base = new BorderPane();
    private static TextField messagefield = new TextField();
    private static TextField chatfield = new TextField();
    final static int ServerPort = 40100;

    public static void main(String args[]) throws UnknownHostException, IOException
    {
        Scanner scanner = new Scanner(System.in);

        // "localhost" equivale a la ip local, en éste caso 127.0.0.27.
        InetAddress ip = InetAddress.getByName("localhost");

        // Crea la conexión
        Socket socket = new Socket(ip, ServerPort);

        // Input y outputs
        DataInputStream datainputstream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataoutputstream = new DataOutputStream(socket.getOutputStream());

        //Selector de flowpane
        chatfield.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {

                FlowPane flowpane = ArrayList.tester(chatfield.getText());
                base.setCenter(flowpane);

            }
        });

        chatfield.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                chatfield.clear();
            }
        });

        // Hilo escritor
        Thread sender = new Thread(new Runnable()
        {
            @Override
            public void run() {
                while (true) {

                    // read the message to deliver.
                    //String message = scanner.nextLine();
                    //Platform.runLater(() -> messages.getChildren().add(Labels.Textconverter(message, true)));

                    messagefield.setOnKeyPressed(event -> {
                        if(event.getCode().equals(KeyCode.ENTER)) {

                            try {
                                FlowPane flowpane = (FlowPane) base.getCenter();
                                // write on the output stream
                                dataoutputstream.writeUTF(messagefield.getText() + "::" + chatfield.getText());
                                flowpane.getChildren().add(Labels.Textconverter(messagefield.getText(), true));
                                messagefield.clear();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }
        });

        // Hilo lector
        Thread reader = new Thread(new Runnable()
        {
            @Override
            public void run() {
                boolean firstmessage = true;

                while (true) {

                    try {
                        String message = datainputstream.readUTF();

                        if(firstmessage){
                            horizontalTB.getItems().add(FirstMessage(message));

                        }else{

                            Platform.runLater(() -> flowfixer = ArrayList.tester(TextWorker.portdivider(message)));
                            Platform.runLater(() -> flowfixer.getChildren().add(Labels.Textconverter(message, false)));
                            Platform.runLater(() -> base.setCenter(flowfixer));

                        }
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                    firstmessage = false;
                }
            }
        });

        sender.start();
        reader.start();
        launch(args);

    }

    public void start(Stage Stage) throws FileNotFoundException {

        //Toolbar HorizontalTB config
        horizontalTB.getItems().add(chatfield);

        //Textfield messagefield config
        messagefield.setMinHeight(35);
        messagefield.setFont(new Font("Arial Black", 12));

        //BorderPane Config
        base.setBottom(messagefield);
        base.setTop(horizontalTB);
        base.setLeft(Toolbars.getRecentchatstoolbar());
        //base.setCenter(messages);
        base.setStyle("-fx-background-color:#3b3838");

        Scene mainscene = new Scene(base,650,730);
        Stage.setMaxWidth(650);
        Stage.setMaxHeight(730);
        Stage.getIcons().add(new Image("file:Icons/Icon.png"));
        Stage.setTitle("SocketChat");
        Stage.setScene(mainscene);
        Stage.show();
    }

}
