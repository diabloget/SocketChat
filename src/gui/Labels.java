package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import sun.font.TextLabel;

public class Labels {


    private static Label Textlabel(String port, String text, boolean own) {
        Label tlabel = new Label(port + text);
        tlabel.setFont(new Font("Arial Black", 12));
        tlabel.setMaxWidth(450);
        tlabel.setMinWidth(450);
        tlabel.setWrapText(true);

        if(own){

            tlabel.setPadding(new Insets(3, 30, 3, 10));
            tlabel.setAlignment(Pos.BASELINE_RIGHT);
            tlabel.setStyle("-fx-background-color:#4c4e9b");

        }else{

            tlabel.setStyle("-fx-background-color:#874083");
            tlabel.setPadding(new Insets(3, 10, 3, 30));
            tlabel.setAlignment(Pos.BASELINE_LEFT);


        }

        return tlabel;

    }

    public static Label Textconverter(String message, boolean own){

        Label label1;

        int index = 0;
        String port;
        String text = "";


        if(own){

            System.out.println("Esto llegó a los labels: " + message);
            text = message.split("::")[0];

            label1 = Textlabel("You: \n", text, own);

        }else{
            System.out.println(message);
            port = message.split("::")[0];
            text = message.split("::")[1];

            label1 = Textlabel(port+": \n", text, own);

        }

        return label1;
    }

    public static Label FirstMessage(String port){
        Label yourport = new Label("Your port is: " + port);
        yourport.setStyle("-fx-background-color:#eeee11");
        yourport.setFont(new Font("Arial Black", 15));
        yourport.setWrapText(true);
        return yourport;

    }

}
