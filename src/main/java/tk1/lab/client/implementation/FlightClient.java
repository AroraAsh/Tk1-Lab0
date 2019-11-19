package tk1.lab.client.implementation;

import java.rmi.RemoteException;
import java.util.List;

import tk1.lab.client.gui.Details;
import tk1.lab.client.gui.FlightListGui;
import tk1.lab.client.interfaces.IFlightClient;
import tk1.lab.server.model.Flight;

public class FlightClient implements IFlightClient {

	@Override
	public void receiveFlights(List<Flight> flights) {
		// TODO Auto-generated method stub
		System.out.println("Receiving Flights:"+flights.size());
		FlightListGui.flightList.clear();
		FlightListGui.flightList.addAll(flights);
		FlightListGui obj = new FlightListGui();
		obj.setFlightListData(FlightListGui.flightList);
	}

	@Override
	public void receiveUpdatedFlight(Flight flight, boolean deleted) {
		// TODO Auto-generated method stub
		String IATACode = flight.getIATACode();
		int flightNumber = flight.getFlightNumber();
		boolean isFound = false;
		int index=-1;
		for(int i=0;i<FlightListGui.flightList.size();i++) {
			Flight f = FlightListGui.flightList.get(i);
			if(f.getIATACode()==IATACode&&f.getFlightNumber()==flightNumber) {
				isFound = true;
				index = i;
			}
		}
		if(isFound)
			if(deleted)
				FlightListGui.flightList.remove(index);
				else
					FlightListGui.flightList.set(index, flight);
		FlightListGui obj = new FlightListGui();
		obj.setFlightListData(FlightListGui.flightList);

	}

}
