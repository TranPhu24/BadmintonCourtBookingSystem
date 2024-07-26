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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURT")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CourtID")
    private Long courtId;

    @Column(name = "location")
    private String location;

    @Column(name = "operatinghours")
    private String operatingHours; 

    @Column(name = "price")
    private String price;
    
    @OneToMany(mappedBy = "court", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Slot> slots = new HashSet<>();

    @OneToMany(mappedBy = "court", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Booking> bookings = new HashSet<>();

    @OneToMany(mappedBy = "court", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Manager> Managers = new HashSet<>();
    
    public Court() {
        super();
    }

    public Court(String location, String operatingHours, String price) {
        super();
        this.location = location;
        this.operatingHours = operatingHours; 
        this.price = price;
    }

    public Long getCourtId() {
        return courtId; 
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
