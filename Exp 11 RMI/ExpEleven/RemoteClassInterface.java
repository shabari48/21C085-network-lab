import java.rmi.*;

public interface RemoteClassInterface extends Remote {
	public void remoteClassMethod(String data) throws RemoteException;
}