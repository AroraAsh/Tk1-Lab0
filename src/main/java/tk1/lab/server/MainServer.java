package tk1.lab.server;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import tk1.lab.server.implementation.FlightServer;
import tk1.lab.server.interfaces.IFlightServer;

public class MainServer extends FlightServer{

	public static FlightServer obj;
	public static IFlightServer stub;
	public static Registry registry;
	
	public static void register (int port) throws RemoteException {
		obj = new FlightServer();
		stub = (IFlightServer)UnicastRemoteObject.exportObject(obj, port);
		LocateRegistry.createRegistry(port);
	    registry = LocateRegistry.getRegistry(port);
	    registry.rebind ("FlightServer", stub);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			register(6010);
			System.out.println("Server Ready");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.err.println("Exception:"+e1.getMessage());
			e1.printStackTrace();
		} 
		
	}

}
