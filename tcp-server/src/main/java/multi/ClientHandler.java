package multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {
    final Socket s;
    final DataOutputStream dout;
    final DataInputStream din;

    public ClientHandler (Socket s, DataOutputStream dout, DataInputStream din) {
        this.s = s;
        this.dout = dout;
        this.din = din;
    }

    @Override
    public void run() {
        String request;
        String response;

        while (true) {
            try {
                request = din.readUTF();
                if(request.equals("exit")){
                    System.out.println("Closing connection with " + s);
                    this.s.close();
                    System.out.println("Closed connection with " + s);
                    break;
                }
                else {
                    response = request + " : RECEIVED";
                    System.out.println("client" + this.s + "says : " + request);
                    dout.writeUTF(response);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        try {
            dout.close();
            din.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
