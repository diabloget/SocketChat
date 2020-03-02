package client;

import code.ArrayList;
import code.TextWorker;
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
import java.io.IOException;
import java.net.Socket;
import java.io.*;
import java.net.*;
import static gui.Labels.FirstMessage;

public class Client extends Application
{
    private static ToolBar horizontalTB = new ToolBar();
    private static ToolBar verticalTB = new ToolBar();
    private static BorderPane base = new BorderPane();
    private static TextField chatfield = new TextField();
<<<<<<< Updated upstream
    private static String actualport;
=======
    private static TextField portfield = new TextField();
>>>>>>> Stashed changes
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
         * flowpane a uno que contenga los mensajes del puerto escrito.
         */
        portfield.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {

<<<<<<< Updated upstream
                FlowPane flowpane = ArrayList.tester(chatfield.getText());
=======
                actualport = portfield.getText();
                FlowPane flowpane = ArrayList.tester(actualport);
>>>>>>> Stashed changes
                base.setCenter(flowpane);

            }
        });

<<<<<<< Updated upstream
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
                                // write on the output stream
                                actualport = chatfield.getText();
                                dataoutputstream.writeUTF(messagefield.getText() + "::" + actualport);
                                FlowPane flowpane = ArrayList.tester(actualport);
                                flowpane.getChildren().add(Labels.Textconverter(messagefield.getText(), true));
                                messagefield.clear();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
=======
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
                            FlowPane flowpane = (FlowPane) base.getCenter();
                            // Escribe en el output
                            dataoutputstream.writeUTF(chatfield.getText() + "::" + actualport);
                            flowpane.getChildren().add(Labels.Textconverter(chatfield.getText(), true));
                            chatfield.clear();

                        } catch (IOException e) {
                            e.printStackTrace();
>>>>>>> Stashed changes
                        }
                    }
                });

            }
        });

        /**
         * Hilo lector, espera a que el dadainputstream reciba un nuevo mensaje y coloca el flowpane
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

<<<<<<< Updated upstream
                            actualport = TextWorker.portdivider(message);
                            chatfield.setText(actualport);
                            FlowPane flowpane = ArrayList.tester(actualport);
                            Platform.runLater(() -> flowpane.getChildren().add(Labels.Textconverter(message, false)));
                            base.setCenter(flowpane);
=======
                        actualport = TextWorker.portdivider(message);
                        Platform.runLater(() -> flowfixer = ArrayList.tester(actualport));
                        Platform.runLater(() -> flowfixer.getChildren().add(Labels.Textconverter(message, false)));
                        Platform.runLater(() -> base.setCenter(flowfixer));
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
        //Toolbar verticalTB config
        verticalTB.setOrientation(Orientation.VERTICAL);
=======
        //Textfield messagefield config
        chatfield.setMinHeight(35);
        chatfield.setFont(new Font("Arial Black", 12));
>>>>>>> Stashed changes

        //BorderPane Config
        base.setBottom(chatfield);
        base.setTop(horizontalTB);
<<<<<<< Updated upstream
        base.setLeft(verticalTB);
        //base.setCenter(messages);
=======
        base.setLeft(Toolbars.getRecentchatstoolbar());
>>>>>>> Stashed changes
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
