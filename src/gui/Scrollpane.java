package gui;

import javafx.scene.control.ScrollPane;

/**
 * Se crea un Scrollpane con las características buscadas, en él se guardarán los
 * VBox, el motivo es que, en un exceso de mensajes, éstos dejan de ser visibles
 * y la scrollbar del scrollpanel se encarga de evitar ese error.
 *
 * @return Scrollpane scrollpane
 */
public class Scrollpane {

    public static ScrollPane getScrollpane(){
        ScrollPane scrollpane = new ScrollPane();
        scrollpane.setStyle("-fx-background-color:#6a6565");
        //scrollpane.setBackground();
        scrollpane.setMinSize(450, 610);
        scrollpane.setMaxSize(450,610);
        scrollpane.setMinViewportHeight(448);
        scrollpane.setMinViewportWidth(608);

        return scrollpane;
    }
}
