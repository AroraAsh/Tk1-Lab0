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
			ex.printStackTrace();
		}
	}
	
	@Override
	public void addNewFlight(String clientName, Flight flight) {
		try {
				Database database = new Database();
				database.updateFlight(flight);
				for(IFlightClient client : database.getClients()) {
					client.receiveFlights(database.getFlights());
				}
				System.out.println(clientName+"::"+flight.getIATACode()+flight.getFlightNumber());
			}catch(Exception ex) {
				System.out.println("Exception:"+ex.getMessage());
				ex.printStackTrace();
			}
	}

	@Override
	public void updateFlight(String clientName, Flight flight) {
		// TODO Auto-generated method stub
		try {
			Database database = new Database();
			database.updateFlight(flight);
			
			System.out.println(clientName+"::"+flight.getIATACode()+flight.getFlightNumber());
			for(IFlightClient client : database.getClients()) {
				client.receiveUpdatedFlight(flight, false);
			}
			
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
		
	}

	@Override
	public void deleteFlight(String clientName, Flight flight) {
		try {
			Database database = new Database();
			database.removeFlight(flight); 
			for(IFlightClient client : database.getClients()) {
				client.receiveUpdatedFlight(flight, true);
			}
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
	}

	@Override
	public void login(String clientName, IFlightClient client) {
		try {
			Database database = new Database();
			database.login(clientName, client);
			System.out.println("Logging in user:"+clientName);
			client.receiveFlights(database.getFlights());
		}catch(Exception ex) {
			System.out.println("Exception:"+ex.getMessage());
			ex.printStackTrace();
		}
	}

}
