package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Server
{

    // Vector to store active clients
    static Vector<ClientHandler> ar = new Vector<>();

    public static void main(String[] args) throws IOException
    {
        //Server port for listening
        ServerSocket socketserver = new ServerSocket(40100);

        Socket socket;

        // running infinite loop for getting
        // client request
        while (true)
        {
            // Accept the incoming request
            socket = socketserver.accept();

            System.out.println("New client request received : " + socket);
            String port =  Integer.toString(socket.getPort());

            // obtain input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            //
            dos.writeUTF(Integer.toString(socket.getPort()));
            System.out.println(socket.getPort() + "Este es el puerto que se le devolvió al cliente");

            System.out.println("Creating a new handler for this client...");

            // Create a new handler object for handling this request.
            ClientHandler mtch = new ClientHandler(socket, port, dis, dos);

            // Create a new Thread with this object.
            Thread t = new Thread(mtch);

            System.out.println("Adding this client to active client list");

            // add this client to active clients list
            ar.add(mtch);

            // start the thread.
            t.start();

        }
    }
}

// ClientHandler class
class ClientHandler implements Runnable
{
    Scanner scanner = new Scanner(System.in);
    private String name;
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;

    // constructor
    public ClientHandler(Socket s, String name,
                         DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.isloggedin=true;
    }

    @Override
    public void run() {

        String received;
        while (true)
        {
            try
            {
                // receive the string
                received = dis.readUTF();

                System.out.println(received);

                if(received.equals("logout")){
                    this.isloggedin=false;
                    this.s.close();
                    break;
                }

                // break the string into message and recipient part
                StringTokenizer divider = new StringTokenizer(received, "::");
                String messagetosend = divider.nextToken();
                String recipient = divider.nextToken();

                // search for the recipient in the connected devices list.
                // ar is the vector storing client of active users
                for (ClientHandler mc : Server.ar)
                {
                    // if the recipient is found, write on its
                    // output stream
                    if (mc.name.equals(recipient) && mc.isloggedin)
                    {
                        mc.dos.writeUTF(this.name+"::"+messagetosend);
                        break;
                    }
                }
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
        try
        {
            // closing resources
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
