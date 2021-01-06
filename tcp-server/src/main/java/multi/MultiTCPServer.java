package multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("listening on port: 6666 . . .");
        //infinite loop for handling client requests and spawning threads
        while(true) {
            Socket s = null;

            try {
                s = ss.accept(); // blocks io
                System.out.println(" new client connection: " + s); //only reaches here on a new connection
                /* Unique Connection Properties
                 * Unique Input and Outstream
                 * Unique Socket object returned by accept()
                 */

                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                DataInputStream din = new DataInputStream(s.getInputStream());


                Thread t = new ClientHandler(s,dout,din);        //creating a new thread to handle the unique request
                t.start();                                       //putting the thread in runnable state

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
}
