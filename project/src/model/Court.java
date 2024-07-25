package model;

public class Court {
	private String CourtID, location,operatinghours,price;

	public Court() {
		super();
	}

	public Court(String courtId, String location, String operatinghours, String price) {
		super();
		CourtID = courtId;
		this.location = location;
		this.operatinghours = operatinghours;
		this.price = price;
	}

	@Override
	public String toString() {
		return "\nCourtId=" + CourtID + ", location=" + location + ", operatinghours=" + operatinghours
				+ ", price=" + price;
	}

	public String getCourtId() {
		return CourtID;
	}

	public void setCourtId(String courtId) {
		CourtID = courtId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOperatinghours() {
		return operatinghours;
	}

	public void setOperatinghours(String operatinghours) {
		this.operatinghours = operatinghours;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
