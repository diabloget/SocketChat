package gui;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class TextFields {

    public static TextField TextFieldMaker(){
        TextField writer = new TextField();

        writer.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {


                writer.clear();

            }
        });

        return writer;
    }

}
