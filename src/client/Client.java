package client;

import code.ArrayList;
import code.TextWorker;
import code.Toolbars;
import gui.Labels;
import gui.Scrollpane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.Socket;
import java.io.*;
import java.net.*;
import static gui.Labels.FirstMessage;

public class Client extends Application
{
    private static VBox VBoxFixer;
    private static String actualport;
    private static ToolBar horizontalTB = new ToolBar();
    private static BorderPane base = new BorderPane();
    private static TextField chatfield = new TextField();
    private static TextField portfield = new TextField();
    private static ScrollPane scrollpane = Scrollpane.getScrollpane();
    final static int ServerPort = 40100;

    public static void main(String args[]) throws IOException
    {

        // "localhost" equivale a la ip local.
        InetAddress ip = InetAddress.getByName("localhost");

        /**
         * Se crea la conexión con el servidor.
         */
        Socket socket = new Socket(ip, ServerPort);

        // Input y output
        DataInputStream datainputstream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataoutputstream = new DataOutputStream(socket.getOutputStream());

        /**
         * Eventos del chatfield de puertos, al ingresar un puerto y darle enter se cambia el
         * VBox a uno que contenga los mensajes del puerto escrito.
         */
        portfield.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {

                actualport = portfield.getText();
                VBox VBox = ArrayList.tester(actualport);
                scrollpane.setContent(VBox);

            }
        });

        portfield.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                portfield.clear();
            }
        });

        /**
         *  Hilo que espera a el evento del textfield (escribir mensaje + darle al enter) para
         *  enviarlo directo a su destino.
         */
        Thread sender = new Thread(() -> {
            while (true) {

                chatfield.setOnKeyPressed(event -> {
                    if(event.getCode().equals(KeyCode.ENTER)) {

                        try {
                            scrollpane = (ScrollPane) base.getCenter();
                            VBox VBox = (VBox) scrollpane.getContent();
                            // Escribe en el output
                            dataoutputstream.writeUTF(chatfield.getText() + "::" + actualport);
                            VBox.getChildren().add(Labels.Textconverter(chatfield.getText(), true));
                            scrollpane.setContent(VBox);
                            scrollpane.setVvalue(1);
                            chatfield.clear();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });

        /**
         * Hilo lector, espera a que el dadainputstream reciba un nuevo mensaje y coloca el VBox
         * correspondiente a dicha conversación
         */
        Thread reader = new Thread(() -> {
            boolean firstmessage = true;

            while (true) {

                try {
                    String message = datainputstream.readUTF();

                    if(firstmessage){
                        horizontalTB.getItems().add(FirstMessage(message));

                    }else{

                        actualport = TextWorker.portdivider(message);
                        Platform.runLater(() -> VBoxFixer = ArrayList.tester(actualport));
                        Platform.runLater(() -> VBoxFixer.getChildren().add(Labels.Textconverter(message, false)));
                        Platform.runLater(() -> scrollpane.setContent(VBoxFixer));
                        Platform.runLater(() -> scrollpane.setVvalue(1));

                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }
                firstmessage = false;
            }
        });

        sender.start();
        reader.start();
        launch(args);

    }

    /**
     * Ejecución de la sección gráfica del código.
     * @param Stage
     */
    public void start(Stage Stage) {

        //Toolbar HorizontalTB config
        horizontalTB.getItems().add(portfield);

        //Textfield messagefield config
        chatfield.setMinHeight(35);
        chatfield.setFont(new Font("Arial Black", 12));

        //BorderPane Config
        base.setCenter(scrollpane);
        base.setBottom(chatfield);
        base.setTop(horizontalTB);
        base.setLeft(Toolbars.getRecentchatstoolbar());
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
