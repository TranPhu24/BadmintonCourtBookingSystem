package model;

public class Payment {
	private String PaymentID,CustomerID,status;
	
	private float amount;

	public Payment() {
		super();
	}

	public Payment(String paymentID, String customerID, float amount, String status) {
		super();
		PaymentID = paymentID;
		CustomerID = customerID;
		this.amount = amount;
		this.status = status;
	}

	@Override
	public String toString() {
		return "\nPaymentID=" + PaymentID + ", CustomerID=" + CustomerID + ", amount=" + amount + ", status="
				+ status;
	}

	public String getPaymentID() {
		return PaymentID;
	}

	public void setPaymentID(String paymentID) {
		PaymentID = paymentID;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
