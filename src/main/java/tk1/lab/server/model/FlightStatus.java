package tk1.lab.server.model;

public enum FlightStatus {
	B("Arrival by bus at Concourse B"),
	D("Diverted"),
	I("Undefined late arrival ordeparture"),
	L("Aborted departure"),
	M("Flight delayed until tomorrow"),
	S("Definitively canceled flight"),
	X("Canceled flight for which there may be a replacement"),
	Y("Return to stand");
	
	private String flightStatusDescription;
	
	FlightStatus(String description){
		this.flightStatusDescription = description;
	}
	
	public String getDescription() {
		return this.flightStatusDescription;
	}
	
}
