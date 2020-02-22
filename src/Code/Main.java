package Code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import java.io.FileNotFoundException;

public class Main extends Application {

    public ToolBar horizontalTB = new ToolBar();
    public ToolBar verticalTB = new ToolBar();
    private BorderPane base = new BorderPane();
    private FlowPane messages = new FlowPane();


    public  void start(Stage Stage) throws FileNotFoundException {

        //Toolbar HorizontalTB config

        //Toolbar verticalTB config
        verticalTB.setOrientation(Orientation.VERTICAL);

        //Flowpane Messages config
        messages.setOrientation(Orientation.VERTICAL);

        Scene mainscene = new Scene(base,650,600);
        // Stage.getIcons().add(icono);
        base.setTop(horizontalTB);
        base.setLeft(verticalTB);
        base.setCenter(messages);
        Stage.setTitle("SocketChat");
        Stage.setScene(mainscene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
