package group6.pojo;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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
    
    @Column(name = "paymentDate")
    private LocalDate paymentDate;

    @Column(name = "paymentTime")
    private LocalTime paymentTime;

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
    public Payment(float amount, String status,LocalDate paymentDate,LocalTime paymentTime, Customer customer) {
		super();
		this.paymentTime = paymentTime;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.status = status;
		this.customer = customer;
	}
	public Payment(Long paymentId, float amount, String status,LocalDate paymentDate,LocalTime paymentTime, Customer customer) {
		this.paymentId = paymentId;
		this.paymentTime = paymentTime;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.status = status;
		this.customer = customer;
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
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate localDate) {
		this.paymentDate = localDate;
	}
	public LocalTime getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(LocalTime localTime) {
		this.paymentTime = localTime;
	}

}
