package code;

import gui.Buttons;
import gui.Flowpanes;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ArrayList {
    public static List<FlowPane> flowpanes = new java.util.ArrayList<>();
    public static List<String> ports = new java.util.ArrayList<>();

    public static FlowPane tester(String port){
        if(ports.indexOf(port) >= 0){
            return flowpanes.get(ports.indexOf(port));

        }else{

            flowpanes.add(Flowpanes.chatflowpane());
            ports.add(port);
            return flowpanes.get(flowpanes.size()-1);

        }
    }

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

}
