import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class ServerSide {
	public static void main(String args[]) {
		try {
			RemoteClassInterface rc = new RemoteClass();

			LocateRegistry.createRegistry(1098);

			Naming.rebind("rmi://localhost:1098/lab", rc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class RemoteClass extends UnicastRemoteObject implements RemoteClassInterface {
	RemoteClass() throws RemoteException {
		super();
	}

	public void remoteClassMethod(String data) {
		System.out.println("Inside the remote method.");
		System.out.println("The data received is " + data);
	}
}