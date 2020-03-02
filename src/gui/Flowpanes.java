package gui;

import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;

public class Flowpanes {

    /**
     * Método para configurar y crear los flowpanes para cada puerto/chat.
     * @return flowpane
     */
    public static FlowPane chatflowpane(){
        FlowPane flowpane = new FlowPane();
        flowpane.setVgap(5);
        flowpane.setOrientation(Orientation.VERTICAL);
<<<<<<< Updated upstream
        flowpane.setMaxSize(450, 500);
=======
        flowpane.setMaxWidth(450);
        flowpane.setMinWidth(450);
        flowpane.setMinHeight(610);
>>>>>>> Stashed changes
        flowpane.setStyle("-fx-background-color:#6a6565");


        return flowpane;
    }
}
