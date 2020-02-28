package code;

public class TextWorker {
    public static String portdivider(String message){

        String port = message.split("::")[0];
        return port;

    }
}
