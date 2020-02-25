package code;

import code.RandomPort;

import gui.Labels;
import gui.TextFields;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client extends Application
{
    private static ToolBar horizontalTB = new ToolBar();
    private static ToolBar verticalTB = new ToolBar();
    private static BorderPane base = new BorderPane();
    private static FlowPane messages = new FlowPane();
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
                    String message = scanner.nextLine();

                    Platform.runLater(() -> messages.getChildren().add(Labels.Textconverter(message, true)));

                    try {
                        // write on the output stream
                        dataoutputstream.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Hilo lector
        Thread reader = new Thread(new Runnable()
        {
            @Override
            public void run() {

                while (true) {
                    try {
                        // read the message sent to this client
                        String message = datainputstream.readUTF();
                        Platform.runLater(() -> messages.getChildren().add(Labels.Textconverter(message, false)));
                        System.out.println(message);
                    } catch (IOException e) {

                        e.printStackTrace();
                    }
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
        base.setBottom(TextFields.TextFieldMaker());
        base.setTop(horizontalTB);
        base.setLeft(verticalTB);
        base.setCenter(messages);
        base.setStyle("-fx-background-color:#3b3838");

        //Flowpane Messages config
        messages.setVgap(5);
        messages.setOrientation(Orientation.VERTICAL);
        messages.setMaxSize(450, 500);
        messages.setStyle("-fx-background-color:#6a6565");

        //Pruebas
        /*
        String ex1 = new String("Mae, ¿A qué hora llego a tu casa?");
        String ex2 = new String("Por cierto, ¿ya comiste? Pensaba llevar una pizza y la pc para volar pichazos toda la noche. Nos vemos en unas horas crack.");
        String ex3 = new String("40505: Mae sí, pero casi nada, tráigase la pizza de fijo. ");
        String ex4 = new String("40505: Lléguese tipo 8pm");

        messages.getChildren().add(Labels.Textconverter(ex1, true));
        messages.getChildren().add(Labels.Textconverter(ex2, true));
        messages.getChildren().add(Labels.Textconverter(ex3, false));
        messages.getChildren().add(Labels.Textconverter(ex4, false));
        */

        Scene mainscene = new Scene(base,650,730);
        Stage.setMaxWidth(650);
        Stage.setMaxHeight(730);
        Stage.getIcons().add(new Image("file:Icons/Icon.png"));
        Stage.setTitle("SocketChat");
        Stage.setScene(mainscene);
        Stage.show();
    }

}
