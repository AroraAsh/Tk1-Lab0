package tk1.lab.server.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import tk1.lab.client.interfaces.IFlightClient;
import tk1.lab.server.model.Flight;

public interface IFlightServer extends Remote {
	void login(String clientName, IFlightClient client) throws RemoteException;
	void logout(String clientName) throws RemoteException;
	void addNewFlight(String clientName,Flight flight)throws RemoteException;
	void updateFlight(String clientName, Flight flight) throws RemoteException;
	void deleteFlight(String clientName, Flight flight) throws RemoteException;
}
