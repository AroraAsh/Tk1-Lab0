package tk1.lab.client.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import tk1.lab.server.model.*;

public interface IFlightClient extends Remote{
	public void receiveFlights(List<Flight> flights) throws RemoteException;
	
	public void receiveUpdatedFlight(Flight flight,boolean deleted) throws RemoteException;

}
