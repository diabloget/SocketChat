package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Labels {

    private void Textlabel(String port, String text, boolean own) {
        Label tlabel = new Label(text);

        if(own){
            tlabel.setPadding(new Insets(0, 5, 0, 0));
            tlabel.setAlignment(Pos.BASELINE_RIGHT);

        }else{
            tlabel.setPadding(new Insets(0, 0, 0, 5));
            tlabel.setAlignment(Pos.BASELINE_LEFT);
        }

    }

    public void Textconverter(String message, boolean own){

        int index = 0;
        String port = "";
        String text = "";

        while(message.substring(index) != ":"){

            port = port + message.substring(index);
            index += 1;

        }

        index += 1;

        while(index < message.length()){

            text = text + message.substring(index);

        }

        if(own){

            Textlabel("You:", text, own);

        }else{

            Textlabel(port+":", text, own);

        }

    }

}
