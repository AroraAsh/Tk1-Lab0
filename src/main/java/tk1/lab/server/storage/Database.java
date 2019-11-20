package tk1.lab.server.storage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import tk1.lab.client.interfaces.IFlightClient;
import tk1.lab.server.model.Flight;

public class Database {
	private static Hashtable<String,Flight> flightList = new Hashtable<>();
	private static HashMap<String,Boolean> userData = new HashMap<>();
	private static HashMap<String,IFlightClient> userIFlightClient = new HashMap<>();
	private static Vector<String> log = new Vector<>();
	
	public void addFlight(Flight flight) {
		this.addToLog("Adding Flight:"+flight.getIATACode()+flight.getFlightNumber());
		Database.flightList.put(flight.getIATACode()+flight.getFlightNumber(),flight);
	}
	
	public void login(String username,IFlightClient client) {
		Database.userIFlightClient.put(username, client);
	}
	
	public IFlightClient getClientObject(String username) {
		return Database.userIFlightClient.get(username);
	}
	
	public void removeFlight(Flight flight) {
		this.addToLog("Removing Flight:"+flight.getIATACode()+flight.getFlightNumber());
		Database.flightList.remove(flight.getIATACode()+flight.getFlightNumber());
	}
	
	public boolean updateFlight(Flight flight) {
		this.addToLog("Updating Flight:"+flight.getIATACode()+flight.getFlightNumber());
		Database.flightList.put(flight.getIATACode()+flight.getFlightNumber(),flight);
		return true;
		
	}
	
	public void addToLog(String logData) {
		Database.log.add(logData);
	}
	
	public String getLog() {
		return String.join(System.lineSeparator(), Database.log);
	}

	public void logoutUser(String userName) {
		Database.userIFlightClient.remove(userName);
	}
	
	public List<Flight> getFlights(){
		List<Flight> flight = new ArrayList<>();
		flight.addAll(Database.flightList.values());
		return flight;
	}
	
	public List<IFlightClient> getClients(){
		List<IFlightClient> clients = new ArrayList<>();
		clients.addAll(Database.userIFlightClient.values());
		return clients;
	}
}
