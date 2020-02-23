package code;

import gui.Labels;
import gui.Labels;
import gui.TextFields;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import java.io.FileNotFoundException;
import gui.Labels.*;

public class Main extends Application {

    private ToolBar horizontalTB = new ToolBar();
    private ToolBar verticalTB = new ToolBar();
    private BorderPane base = new BorderPane();
    private FlowPane messages = new FlowPane();


    public  void start(Stage Stage) throws FileNotFoundException {

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
        String ex1 = new String("Mae, ¿A qué hora llego a tu casa?");
        String ex2 = new String("Por cierto, ¿ya comiste? Pensaba llevar una pizza y la pc para volar pichazos toda la noche. Nos vemos en unas horas crack.");
        String ex3 = new String("40505: Mae sí, pero casi nada, tráigase la pizza de fijo. ");
        String ex4 = new String("40505: Lléguese tipo 8pm");

        messages.getChildren().add(Labels.Textconverter(ex1, true));
        messages.getChildren().add(Labels.Textconverter(ex2, true));
        messages.getChildren().add(Labels.Textconverter(ex3, false));
        messages.getChildren().add(Labels.Textconverter(ex4, false));

        Scene mainscene = new Scene(base,650,730);
        Stage.setMaxWidth(650);
        Stage.setMaxHeight(730);
        Stage.getIcons().add(new Image("file:Icons/Icon.png"));
        Stage.setTitle("SocketChat");
        Stage.setScene(mainscene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
