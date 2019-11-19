package tk1.lab.server.model;

import java.io.Serializable;
import java.util.Date;

public class ArrivalDepartureData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -53695862163854066L;
	String airport;
	String terminal;
	Date scheduledDateTime;
	Integer gateNo;
	Date estimatedDateTime;
	CheckIn checkInData;
	
	
	
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public Date getScheduledDateTime() {
		return scheduledDateTime;
	}
	public void setScheduledDateTime(Date scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}
	public Integer getGateNo() {
		return gateNo;
	}
	public void setGateNo(Integer gateNo) {
		this.gateNo = gateNo;
	}
	public Date getEstimatedDateTime() {
		return estimatedDateTime;
	}
	public void setEstimatedDateTime(Date estimatedDateTime) {
		this.estimatedDateTime = estimatedDateTime;
	}
	public CheckIn getCheckInData() {
		return checkInData;
	}
	public void setCheckInData(CheckIn checkInData) {
		this.checkInData = checkInData;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	
	
}
