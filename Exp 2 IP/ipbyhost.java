import java.net.*;
import java.util.Scanner;

public class ipbyhost{
 public static void main(String[] args){
try{
    Scanner myobj = new Scanner(System.in);
     System.out.println("Enter the host name: ");
     String input=myobj.nextLine();
  InetAddress host= InetAddress.getByName(input);
  System.out.println("Given Host Ip Address: "+ host.getHostAddress());
}
catch(Exception e){
System.out.println(e);
}
}
}