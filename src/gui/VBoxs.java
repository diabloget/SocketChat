package gui;

import javafx.scene.layout.VBox;

public class VBoxs {

    /**
     * Método para configurar y crear los VBoxes para cada puerto/chat.
     * @return VBox
     */
    public static VBox ChatVBox(){
        VBox VBox = new VBox();
        VBox.setMaxWidth(435);
        VBox.setMinWidth(435);
        VBox.setMinHeight(608);
        VBox.setSpacing(3);
        VBox.setStyle("-fx-background-color:#6a6565");


        return VBox;
    }
}
