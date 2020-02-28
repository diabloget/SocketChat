package gui;

import code.ArrayList;
import code.TextWorker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class Buttons {
    public static Button startchat(String port, TextField messagefield){
        Button Start = new Button("Start Chat")
                ;
        DropShadow shadow = new DropShadow();
        //Adding the shadow when the mouse cursor is on
        Start.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                Start.setEffect(shadow);
            }
        });
        //Removing the shadow when the mouse cursor is off
        Start.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                Start.setEffect(null);
            }
        });

        Start.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ArrayList.tester(port);
                messagefield.clear();
            }
        });

        return Start;

    }

    public static Button chatbutton(String port){
        Button chatbutton = new Button(port);

        DropShadow shadow = new DropShadow();
        //Adding the shadow when the mouse cursor is on
        chatbutton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                chatbutton.setEffect(shadow);
            }
        });
        //Removing the shadow when the mouse cursor is off
        chatbutton.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                chatbutton.setEffect(null);
            }
        });

        chatbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

            }
        });
        return chatbutton;
    }
}
