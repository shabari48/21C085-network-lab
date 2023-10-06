import java.io.*;
import java.net.*;

public class ServerUDP {

  public static void main(String args[]) throws IOException {
    byte b[] = new byte[3072];
    DatagramSocket dsoc = new DatagramSocket(1000);
    FileOutputStream f = new FileOutputStream("receive.txt");
    while (true) {
      DatagramPacket dp = new DatagramPacket(b, b.length);
      dsoc.receive(dp);
      f.write(dp.getData(), 0, dp.getLength());
      System.out.println("Recieved successfully!");
    }
  }
}
