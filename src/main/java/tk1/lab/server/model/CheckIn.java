package tk1.lab.server.model;

import java.util.Date;

public class CheckIn {
	int checkInLocation;
	int checkInCounter;
	Date checkInTimeStart;
	Date checkInTimeEnd;
	
	public int getCheckInLocation() {
		return checkInLocation;
	}
	public void setCheckInLocation(int checkInLocation) {
		this.checkInLocation = checkInLocation;
	}
	public int getCheckInCounter() {
		return checkInCounter;
	}
	public void setCheckInCounter(int checkInCounter) {
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
