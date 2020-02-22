package code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import java.io.FileNotFoundException;

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
        base.setTop(horizontalTB);
        base.setLeft(verticalTB);
        base.setCenter(messages);
        base.setStyle("-fx-background-color:#3b3838");

        //Flowpane Messages config
        messages.setOrientation(Orientation.VERTICAL);
        messages.setMaxSize(450, 500);
        messages.setStyle("-fx-background-color:#6a6565");

        //Pruebas
        Label ex1 = new Label("Mae, ¿qué día nos podemos ver?");
        Label ex2 = new Label("Por cierto, ¿ya comiste? Pensaba llevar una pizza y la pc para volar pichazos toda la noche. Nos vemos en unas horas crack aaaaaaaaaaassssddf");
        ex1.setWrapText(true);
        ex1.setMaxWidth(450);
        ex2.setWrapText(true);
        ex2.setMaxWidth(450);
        messages.getChildren().add(ex1);
        messages.getChildren().add(ex2);

        Scene mainscene = new Scene(base,650,600);
        // Stage.getIcons().add(icono);
        Stage.setTitle("SocketChat");
        Stage.setScene(mainscene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
