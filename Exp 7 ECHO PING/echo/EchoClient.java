import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        String sockin;
        try {
            Socket socket = new Socket("localhost", 2000);
            Scanner sc = new Scanner(System.in);
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            System.out.println("Start echoing... type 'end' to terminate");
            while ((sockin = sc.nextLine()) != null) {
                dout.writeUTF(sockin);
                if (sockin.equals("end"))
                    break;
                else
                    System.out.println("echoed from server:" + din.readUTF());

            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
