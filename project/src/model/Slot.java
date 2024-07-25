package model;

import java.sql.Time;

public class Slot {
	private String SlotID, CourtID;
	private Time startTime,endTime;

	public Slot() {
		super();
	}

	public Slot(String slotID, String courtID, Time startTime, Time endTime) {
		super();
		SlotID = slotID;
		CourtID = courtID;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "\nSlotID=" + SlotID + ", CourtID=" + CourtID + ", startTime=" + startTime + ", endTime=" + endTime;
	}

	public String getSlotID() {
		return SlotID;
	}

	public void setSlotID(String slotID) {
		SlotID = slotID;
	}

	public String getCourtID() {
		return CourtID;
	}

	public void setCourtID(String courtID) {
		CourtID = courtID;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
}
