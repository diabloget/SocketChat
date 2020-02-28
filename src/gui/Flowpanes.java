package gui;

import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;

public class Flowpanes {

    public static FlowPane chatflowpane(){
        FlowPane flowpane = new FlowPane();
        flowpane.setVgap(5);
        flowpane.setOrientation(Orientation.VERTICAL);
        flowpane.setMaxSize(450, 500);
        flowpane.setStyle("-fx-background-color:#6a6565");


        return flowpane;
    }
}
