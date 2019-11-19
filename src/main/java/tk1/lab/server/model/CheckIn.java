package tk1.lab.server.model;

import java.io.Serializable;
import java.util.Date;

public class CheckIn implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6290422679476399899L;
	int checkInLocation;
	String checkInCounter;
	Date checkInTimeStart;
	Date checkInTimeEnd;
	
	public int getCheckInLocation() {
		return checkInLocation;
	}
	public void setCheckInLocation(int checkInLocation) {
		this.checkInLocation = checkInLocation;
	}
	public String getCheckInCounter() {
		return checkInCounter;
	}
	public void setCheckInCounter(String checkInCounter) {
		this.checkInCounter = checkInCounter;
	}
	public Date getCheckInTimeStart() {
		return checkInTimeStart;
	}
	public void setCheckInTimeStart(Date checkInTimeStart) {
		this.checkInTimeStart = checkInTimeStart;
	}
	public Date getCheckInTimeEnd() {
		return checkInTimeEnd;
	}
	public void setCheckInTimeEnd(Date checkInTimeEnd) {
		this.checkInTimeEnd = checkInTimeEnd;
	}
}
