import java.net.*;  
import java.io.*;  
import java.text.SimpleDateFormat;
import java.util.*; 
class TimeClient{  
public static void main(String args[])throws Exception{  
Socket s=new Socket("localhost",3333);  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2="";  
while(!str.equals("stop")){  
str=br.readLine();  
dout.writeUTF(str);  
dout.flush();  
str2=din.readUTF();
String currentTime = getCurrentTime();
System.out.println("Server says: "+str2+" "+currentTime);  
}  
  
dout.close();  
s.close();  
}

 private static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}  