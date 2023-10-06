import java.net.*;
public class net4{
public static void main(String[] args){
    for(int p = 1; p <= 65535; p++){
        try{
            Socket s = new Socket("localhost", p);
            s.close();
            System.out.println("Port " + p + " is open");
        }
        catch(Exception e){
		//port not open
        }
    }
}
}