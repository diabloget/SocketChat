package code;

import gui.Labels;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;

public class Toolbars {
    private static ToolBar recentchatstoolbar = new ToolBar(Labels.top());

    /**
     * Método para configurar la toolbar que indica las conversaciones recientes.
     * @return toolbar recentchatstollbar
     */
    public static ToolBar getRecentchatstoolbar() {
        recentchatstoolbar.setStyle("-fx-background-color:#6f6f6e");
        recentchatstoolbar.setOrientation(Orientation.VERTICAL);
        recentchatstoolbar.setOpacity(0.4);

        recentchatstoolbar.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> recentchatstoolbar.setOpacity(1));

        // Elimina la sombra al colocar el mouse encima.
        recentchatstoolbar.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> recentchatstoolbar.setOpacity(0.4));

        return recentchatstoolbar;
    }

    /**
     * Método que agrega un label con el último puerto con el que se mantuvo un chat.
     * @param recentchat
     */
    public static void Toolbaradder(Label recentchat){
        recentchatstoolbar.getItems().add(recentchat);
    }

}
