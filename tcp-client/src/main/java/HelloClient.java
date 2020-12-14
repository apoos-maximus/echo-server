import java.io.DataOutputStream;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",6666);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Hello World !");
            dos.flush();
            dos.close();
            s.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
