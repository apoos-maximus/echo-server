package oneone;

import java.io.*;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) throws IOException {
        try {
            Socket s = new Socket("localhost",6666);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str="",str2="";

            while (!str.equals("stop")){
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                str2 = din.readUTF();
                System.out.println("Server says : " + str2);
            }
            dout.close();       // Client stops talking
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}