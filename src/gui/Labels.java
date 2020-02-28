package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
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
    public static Label RecentChats(String port){
        Label recentchat = new Label(port);
        recentchat.setStyle("-fx-background-color:#ffff0c");
        recentchat.setFont(new Font("Arial Black", 13));
        recentchat.setPadding(new Insets(8, 15, 8, 15));
        recentchat.setWrapText(true);
        recentchat.setMaxWidth(158);
        recentchat.setMinWidth(158);

        recentchat.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(port);
                clipboard.setContent(content);
            }
        });

        return recentchat;
    }

    public static Label top(){
        Label top = new Label("Your Recent Chats:");
        top.setStyle("-fx-background-color:#6f6f6e");
        top.setFont(new Font("Arial Black", 13));
        top.setPadding(new Insets(15, 10, 15, 10));
        top.setWrapText(true);
        top.setMaxWidth(150);
        top.setMinWidth(150);

        return top;
    }


}
