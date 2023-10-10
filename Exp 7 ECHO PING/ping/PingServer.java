import java.io.*;
import java.net.*;
import java.util.*;

public class PingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            String str = din.readUTF();
            System.out.println("Ping command received from : " + socket.getInetAddress() + " with string " + str);
            dout.writeUTF(str);
        }
    }
}
