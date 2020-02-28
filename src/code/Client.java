package code;

import gui.Buttons;
import gui.Labels;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
    private static ToolBar horizontalTB = new ToolBar();
    private static ToolBar verticalTB = new ToolBar();
    private static BorderPane base = new BorderPane();
    private static FlowPane messages = new FlowPane();
    private static TextField textfield = new TextField();
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

        // Hilo escritor
        Thread sender = new Thread(new Runnable()
        {
            @Override
            public void run() {
                while (true) {

                    // read the message to deliver.
                    //String message = scanner.nextLine();
                    //Platform.runLater(() -> messages.getChildren().add(Labels.Textconverter(message, true)));

                    textfield.setOnKeyPressed(event -> {
                        if(event.getCode().equals(KeyCode.ENTER)) {

                            try {
                                // write on the output stream
                                dataoutputstream.writeUTF(textfield.getText());
                                messages.getChildren().add(Labels.Textconverter(textfield.getText(), true));
                                textfield.clear();

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

                            // read the message sent to this client
                            Platform.runLater(() -> messages.getChildren().add(Labels.Textconverter(message, false)));
                            System.out.println(message);

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

        //Toolbar verticalTB config
        verticalTB.setOrientation(Orientation.VERTICAL);

        //BorderPane Config
        base.setBottom(textfield);
        base.setTop(horizontalTB);
        base.setLeft(verticalTB);
        base.setCenter(messages);
        base.setStyle("-fx-background-color:#3b3838");

        //Flowpane Messages config
        messages.setVgap(5);
        messages.setOrientation(Orientation.VERTICAL);
        messages.setMaxSize(450, 500);
        messages.setStyle("-fx-background-color:#6a6565");

        Scene mainscene = new Scene(base,650,730);
        Stage.setMaxWidth(650);
        Stage.setMaxHeight(730);
        Stage.getIcons().add(new Image("file:Icons/Icon.png"));
        Stage.setTitle("SocketChat");
        Stage.setScene(mainscene);
        Stage.show();
    }

}
