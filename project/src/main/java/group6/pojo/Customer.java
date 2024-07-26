package group6.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "CustomerID")
    private String customerId;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
    
    @OneToOne
    @JoinColumn(name = "AccountID", unique = true)
    private Account account;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Booking> bookings;
    
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Payment> payments;
    
    public Customer() {
        super();
    }

    public Customer(String customerId, String customerName, String email, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
