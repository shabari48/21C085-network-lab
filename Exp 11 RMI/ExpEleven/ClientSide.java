import java.rmi.*;

public class ClientSide {
	public static void main(String args[]) {
		String dataFromClient = "Hey, its a call from the client";

		try {
			RemoteClassInterface rc = (RemoteClassInterface) Naming.lookup("rmi://localhost:1098/lab");

			rc.remoteClassMethod(dataFromClient);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}