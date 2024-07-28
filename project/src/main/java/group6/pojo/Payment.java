package group6.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PaymentID")
    private Long paymentId;


    @Column(name = "amount")
    private float amount;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID")
    private Customer customer;
    
    @OneToMany(mappedBy = "payment",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Court> courts=new HashSet<Court>();
    
    public Payment() {
        super();
    }

    public Payment(Long paymentId, String customerId, float amount, String status) {
        super();
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
    }
    
    

    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Court> getCourts() {
		return courts;
	}

	public void setCourts(Set<Court> courts) {
		this.courts = courts;
	}

	public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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
