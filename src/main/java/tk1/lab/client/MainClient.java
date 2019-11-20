package tk1.lab.client;

import java.awt.EventQueue;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.swing.JDialog;

import tk1.lab.client.gui.FlightListGui;
import tk1.lab.client.gui.Logins;
import tk1.lab.client.implementation.FlightClient;
import tk1.lab.client.interfaces.IFlightClient;
import tk1.lab.server.implementation.FlightServer;
import tk1.lab.server.interfaces.IFlightServer;
import tk1.lab.server.model.Flight;

public class MainClient {

	public static IFlightServer stub;
	public static FlightClient client;
	public static IFlightClient clientStub;
	public static Registry registry;
	public static String clientName;
	
	public static void register (int port) throws RemoteException, NotBoundException {
		client = new FlightClient();
	    clientStub = (IFlightClient) UnicastRemoteObject.exportObject(client, 0);
	    registry = LocateRegistry.getRegistry(port);
		stub = (IFlightServer) registry.lookup("FlightServer");
	    
	    //registry.rebind("ClientObject", clientStub);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			register(6010);
			Logins dialog = new Logins();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage()+ex.getStackTrace().toString());
			ex.printStackTrace();
		}
	}
	
	public int getAvailablePort() {
		int baseVal = 6011;
		return baseVal;
	}

}
