import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        String echoin;
        ServerSocket serverSocket;
        Socket socket;
        try
        {
            serverSocket = new ServerSocket(2000);
            socket = serverSocket.accept();
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected for echo:");
            while((echoin= din.readUTF())!=null)
            {
                if(echoin.equals("end"))
                {
                    System.out.println("Client disconnected");
                    din.close();
                    break;
                }
                else
                    dout.writeUTF(echoin);
            }
        }
        catch (Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }
}
