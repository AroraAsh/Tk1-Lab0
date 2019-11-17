package tk1.lab.server.model;

import java.util.Date;

public class Flight {
	int flightNumber;
	String IATACode;
	String airlineName;
	String aircraftType;
	Date originDate;
	ArrivalDepartureData arrivalData;
	ArrivalDepartureData departureData;
	FlightStatus status;
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getIATACode() {
		return IATACode;
	}
	public void setIATACode(String iATACode) {
		IATACode = iATACode;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getAircraftType() {
		return aircraftType;
	}
	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}
	public Date getOriginDate() {
		return originDate;
	}
	public void setOriginDate(Date originDate) {
		this.originDate = originDate;
	}
	public ArrivalDepartureData getArrivalData() {
		return arrivalData;
	}
	public void setArrivalData(ArrivalDepartureData arrivalData) {
		this.arrivalData = arrivalData;
	}
	public ArrivalDepartureData getDepartureData() {
		return departureData;
	}
	public void setDepartureData(ArrivalDepartureData departureData) {
		this.departureData = departureData;
	}
	public FlightStatus getStatus() {
		return status;
	}
	public void setStatus(FlightStatus status) {
		this.status = status;
	}
}
