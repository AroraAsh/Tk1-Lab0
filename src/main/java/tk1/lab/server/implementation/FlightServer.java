package tk1.lab.server.implementation;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import tk1.lab.client.interfaces.IFlightClient;
import tk1.lab.server.interfaces.IFlightServer;
import tk1.lab.server.model.Flight;
import tk1.lab.server.storage.*;

public class FlightServer implements IFlightServer {

	@Override
	public void logout(String clientName) {
		// TODO Auto-generated method stub
		try {
			Database database = new Database();
			database.logoutUser(clientName);
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage());
		}
	}

	@Override
	public void updateFlight(String clientName, Flight flight) {
		// TODO Auto-generated method stub
		try {
		Database database = new Database();
		database.updateFlight(flight);
		IFlightClient client = database.getClientObject(clientName);
		database.getClientObject(clientName).receiveUpdatedFlight(flight, false);
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage());
		}
		
	}

	@Override
	public void deleteFlight(String clientName, Flight flight) {
		try {
			Database database = new Database();
			database.removeFlight(flight); 
			database.getClientObject(clientName).receiveUpdatedFlight(flight, true);
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage());
		}
	}

	@Override
	public void login(String clientName, IFlightClient client) {
		try {
			Database database = new Database();
			database.login(clientName, client);
			client.receiveFlights(database.getFlights());
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage());
		}
	}

}
