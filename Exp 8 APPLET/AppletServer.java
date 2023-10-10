
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class AppletServer extends Applet implements ActionListener, Runnable {
   Button b1;
   TextField tf;
   TextArea ta;

   ServerSocket ss;
   Socket s;
   PrintWriter pw;
   BufferedReader br;

   Thread th;

   public AppletServer() {
      Frame f = new Frame("Server");
      f.setLayout(new FlowLayout());
      f.addWindowListener(new W1());
    
      b1 = new Button("Send");
      b1.addActionListener(this);
      tf = new TextField(15);
      ta = new TextArea(20, 20);

      f.add(tf);
      f.add(b1);
      f.add(ta);

      try {
         ss = new ServerSocket(12000);
         s = ss.accept();
         System.out.println(s);
         br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         pw = new PrintWriter(s.getOutputStream(), true);
      } catch (Exception e) {
      }
      th = new Thread(this);
      th.setDaemon(true);
      th.start();
   
      f.setSize(200, 200);
      f.setVisible(true);
      f.setLocation(700, 300);
  
   }

   private class W1 extends WindowAdapter {
      public void windowClosing(WindowEvent we) {
         System.exit(0);
      }
   }

   public void actionPerformed(ActionEvent ae) {
      pw.println("Server says:" + tf.getText());
      tf.setText("");
   }

   public void run() {
      while (true) {
         try {
            ta.append(br.readLine() + "\n");
         } catch (Exception e) {
         }
      }
   }

   public static void main(String args[]) {
      AppletServer server = new AppletServer();
   }
}
