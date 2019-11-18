package tk1.lab.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import tk1.lab.server.implementation.FlightServer;
import tk1.lab.server.interfaces.IFlightServer;

public class MainServer extends FlightServer{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FlightServer obj = new FlightServer();
			IFlightServer stub = (IFlightServer)UnicastRemoteObject.exportObject(obj, 0);
			Registry registry = LocateRegistry.getRegistry(); 
	        registry.bind("FlightServer", stub);  
	        System.err.println("Server ready");
		}catch(Exception ex) {
	
		}
	}

}
