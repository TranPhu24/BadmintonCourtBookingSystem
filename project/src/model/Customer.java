package model;

public class Customer {
	private String CustomerID, CustomerName,email, phone;

	public Customer() {
		super();
	}
	public Customer(String customerId, String customerName, String email, String phone) {
		super();
		CustomerID = customerId;
		CustomerName = customerName;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "\nCustomerId=" + CustomerID + ", CustomerName=" + CustomerName + ", email=" + email + ", phone="
				+ phone;
	}
	public String getCustomerId() {
		return CustomerID;
	}
	public void setCustomerId(String customerId) {
		CustomerID = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
