package tk1.lab.client;

import java.awt.EventQueue;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.swing.JDialog;

import tk1.lab.client.gui.FlightListGui;
import tk1.lab.client.gui.Logins;
import tk1.lab.client.implementation.FlightClient;
import tk1.lab.client.interfaces.IFlightClient;
import tk1.lab.server.interfaces.IFlightServer;
import tk1.lab.server.model.Flight;

public class MainClient {

	public static IFlightServer stub;
	public static FlightClient client;
	public static IFlightClient clientStub;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Registry registry = LocateRegistry.createRegistry(1888); 
	    
        // Looking up the registry for the remote object 
        //stub = (IFlightServer) registry.lookup("FlightServer"); 
        client = new FlightClient();
        clientStub = (IFlightClient) UnicastRemoteObject.exportObject(client, 1888);
        registry.bind("ClientObject", clientStub);
		Logins dialog = new Logins();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage()+ex.getStackTrace().toString());
		}
	}

}
