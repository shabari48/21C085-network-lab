import java.io.*;
import java.net.*;
import java.util.*;

public class PingClient {
    public static void main(String[] args) throws IOException {
        long t1, t2;
        while(true){
            try{
                Socket socket = new Socket("localhost", 2000);
                Scanner sc = new Scanner(System.in);
                System.out.println("Type a string to ping : ");
                String str = sc.next();
                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                DataInputStream din = new DataInputStream(socket.getInputStream());
                t1 = System.currentTimeMillis();
                dout.writeUTF(str);

                String str1 = din.readUTF();
                t2 = System.currentTimeMillis();
                System.out.println("Pinging "+socket.getInetAddress()+" with string "+ str);
                System.out.println("Reply from "+ socket.getInetAddress()+" String "+str1+" Length : "+str1.length());
                System.out.println("Sent : "+str.length()+" Recieved : "+str1.length()+" Lost : "+(str.length() - str1.length()));
                System.out.println("Approx. Time in Milliseconds = "+(t2-t1));
            }
            catch(Exception e){
                System.out.println("Error : "+e.getMessage());
            }
        }

    }
}
