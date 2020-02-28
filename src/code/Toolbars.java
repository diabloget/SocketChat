package code;

import gui.Labels;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;

public class Toolbars {
    private static ToolBar recentchatstoolbar = new ToolBar(Labels.top());

    public static ToolBar getRecentchatstoolbar() {
        recentchatstoolbar.setStyle("-fx-background-color:#6f6f6e");
        recentchatstoolbar.setOrientation(Orientation.VERTICAL);
        recentchatstoolbar.setOpacity(0.4);
        recentchatstoolbar.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        recentchatstoolbar.setOpacity(1);
                    }
                });
        //Removing the shadow when the mouse cursor is off
        recentchatstoolbar.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        recentchatstoolbar.setOpacity(0.4);
                    }
                });
        return recentchatstoolbar;
    }

    public static void Toolbaradder(Label recentchat){
        recentchatstoolbar.getItems().add(recentchat);
    }

}
