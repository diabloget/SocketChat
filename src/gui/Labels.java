package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Font;

public class Labels {

    /**
     * Método que agrega la configuración al label de cada mensaje recibido/enviado.
     * @param port
     * @param text
     * @param own
     * @return label messagelabel
     */
    private static Label Textlabel(String port, String text, boolean own) {
        Label messagelabel = new Label(port + text);
        messagelabel.setFont(new Font("Arial Black", 12));
        messagelabel.setMaxWidth(435);
        messagelabel.setMinWidth(435);
        messagelabel.setWrapText(true);

        if(own){

            messagelabel.setPadding(new Insets(3, 30, 3, 10));
            messagelabel.setAlignment(Pos.BASELINE_RIGHT);
            messagelabel.setStyle("-fx-background-color:#4c4e9b");

        }else{

            messagelabel.setStyle("-fx-background-color:#874083");
            messagelabel.setPadding(new Insets(3, 10, 3, 30));
            messagelabel.setAlignment(Pos.BASELINE_LEFT);


        }

        return messagelabel;

    }

    /**
     * Método que trabaja en conjunto con el método Textlabel para configurar los labels
     * correspondientes a los mensajes recibidos/enviados dentro del VBox.
     * @param message
     * @param own
     * @return label messagelabel
     */
    public static Label Textconverter(String message, boolean own){

        Label messagelabel;

        int index = 0;
        String port;
        String text = "";


        if(own){

            System.out.println("Esto llegó a los labels: " + message);
            text = message.split("::")[0];

            messagelabel = Textlabel("You: \n", text, own);

        }else{
            System.out.println(message);
            port = message.split("::")[0];
            text = message.split("::")[1];

            messagelabel = Textlabel(port+": \n", text, own);

        }

        return messagelabel;
    }

    /**
     * Método para crear label que indique el puerto propio del cliente.
     * @param port
     * @return label yourport
     */
    public static Label FirstMessage(String port){
        Label yourport = new Label("Your port is: " + port);
        yourport.setStyle("-fx-background-color:#eeee11");
        yourport.setFont(new Font("Arial Black", 15));
        yourport.setWrapText(true);

        yourport.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(port);
                clipboard.setContent(content);
            }
        });
        return yourport;

    }

    /**
     * Método para agregar los labels que indican los puertos con los que se habló recientemente.
     * @param port
     * @return label recentchat
     */
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

    /**
     * Método para el label inicial de los chatsrecientes.
     * @return Label top
     */
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
