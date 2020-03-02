package code;

import gui.Flowpanes;
<<<<<<< Updated upstream
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
=======
import gui.Labels;
>>>>>>> Stashed changes
import javafx.scene.layout.FlowPane;
import java.util.List;

public class ArrayList {
    public static List<FlowPane> flowpanes = new java.util.ArrayList<>();
    public static List<String> ports = new java.util.ArrayList<>();

    /**
     * Método que al recibir un puerto nuevo, crea un flowpane para su chat y agrega a ambos a sus
     * correspondientes arraylist, en caso de ya existir el puerto en la arraylist, consigue su
     * índice para con él extraer el flowpane asociado a ese puerto y así mostrar el chat con él.
     * @param port
     * @return flowpane
     */
    public static FlowPane tester(String port){
        if(ports.indexOf(port) >= 0){
            return flowpanes.get(ports.indexOf(port));

        }else{

            flowpanes.add(Flowpanes.chatflowpane());
            ports.add(port);
            return flowpanes.get(flowpanes.size()-1);

        }
    }

<<<<<<< Updated upstream
    public static void flowportadder(String port, FlowPane flowpane){
        flowpanes.add(flowpane);
        ports.add(port);

    }

    public static Label RecentChats(String port){
        Label recentchat = new Label(port);
        recentchat.setStyle("-fx-background-color:#6a6565");
        recentchat.setFont(new Font("Arial Black", 13));
        recentchat.setWrapText(true);

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

=======
>>>>>>> Stashed changes
}
