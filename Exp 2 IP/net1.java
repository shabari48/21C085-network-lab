import java.net.*;
public class net1{
 public static void main(String[] args){
try{
  InetAddress host= InetAddress.getLocalHost();
  System.out.println("Local Host Ip Address: "+ host.getHostAddress());
  System.out.println("Local Host Name: "+host.getHostName());
}
catch(Exception e){
System.out.println(e);
}
}
}