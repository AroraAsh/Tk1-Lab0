package tk1.lab.client.implementation;

import java.rmi.RemoteException;
import java.util.List;

import tk1.lab.client.gui.FlightListGui;
import tk1.lab.client.interfaces.IFlightClient;
import tk1.lab.server.model.Flight;

public class FlightClient implements IFlightClient {

	@Override
	public void receiveFlights(List<Flight> flights) {
		// TODO Auto-generated method stub
		FlightListGui.flightList.clear();
		FlightListGui.flightList.addAll(flights);
		FlightListGui obj = new FlightListGui();
		obj.setFlightListData(FlightListGui.flightList);
	}

	@Override
	public void receiveUpdatedFlight(Flight flight, boolean deleted) {
		// TODO Auto-generated method stub

	}

}
