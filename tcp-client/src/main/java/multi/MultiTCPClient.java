package multi;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MultiTCPClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String request = "";
            String response = "";
            while (!request.equals("exit")){
                request = br.readLine();
                dout.writeUTF(request);
                dout.flush();

                response = din.readUTF();
                System.out.println(response);
            }
            s.close();
            dout.close();
            din.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
