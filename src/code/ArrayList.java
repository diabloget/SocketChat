package code;

import gui.Labels;
import gui.VBoxs;
import javafx.scene.layout.VBox;

import java.util.List;

public class ArrayList {
    public static List<VBox> VBoxes = new java.util.ArrayList<>();
    public static List<String> ports = new java.util.ArrayList<>();

    /**
     * Método que al recibir un puerto nuevo, crea un VBox para su chat y agrega a ambos a sus
     * correspondientes arraylist, en caso de ya existir el puerto en la arraylist, consigue su
     * índice para con él extraer el VBox asociado a ese puerto y así mostrar el chat con él.
     * @param port
     * @return VBox
     */
    public static VBox tester(String port){
        if(ports.indexOf(port) >= 0){
            return VBoxes.get(ports.indexOf(port));

        }else{

            Toolbars.Toolbaradder(Labels.RecentChats(port));
            VBoxes.add(VBoxs.ChatVBox());
            ports.add(port);
            return VBoxes.get(VBoxes.size()-1);

        }
    }

}
