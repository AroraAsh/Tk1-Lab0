package tk1.lab.server.interfaces;

import java.rmi.Remote;

import tk1.lab.client.interfaces.IFlightClient;
import tk1.lab.server.model.Flight;

public interface IFlightServer extends Remote {
	void login(String clientName, IFlightClient client);
	void logout(String clientName);
	void updateFlight(String clientName, Flight flight);
	void deleteFlight(String clientName, Flight flight);
}
