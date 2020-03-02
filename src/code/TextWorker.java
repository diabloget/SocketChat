package code;

public class TextWorker {

    /**
     * Método que extrae el puerto del mensaje recibido.
     * @param message
     * @return String port
     */
    public static String portdivider(String message){

        String port = message.split("::")[0];
        return port;

    }
}
