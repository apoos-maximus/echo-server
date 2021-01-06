package oneone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class HelloServer {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            System.out.println("listnening on port:6666");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str="",str2="";

            while(!str.equals("stop")){
                str = din.readUTF();
                System.out.println("client says: " + str);
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }
            din.close();        // Server stops listening
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}