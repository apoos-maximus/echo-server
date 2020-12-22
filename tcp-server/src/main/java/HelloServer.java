import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            while(true) {
                System.out.println("\nlistening on tcp:6666...");
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = dis.readUTF();
                System.out.println("message = " + str);
                s.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
