package model;

import java.sql.Date;
import java.sql.Time;

public class Booking {
	private String BookingID,CustomerID,bookingType;
	private Time bookingTime;
	private Date bookingDate;

	public Booking() {
		super();
	}

	public Booking(String bookingID, String customerID, String bookingType, Date bookingDate, Time bookingTime) {
		super();
		BookingID = bookingID;
		CustomerID = customerID;
		this.bookingType = bookingType;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
	}

	@Override
	public String toString() {
		return "\nBookingID=" + BookingID + ", CustomerID=" + CustomerID + ", bookingType=" + bookingType
				+ ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime;
	}

	public String getBookingID() {
		return BookingID;
	}

	public void setBookingID(String bookingID) {
		BookingID = bookingID;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Time getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}
	
}
