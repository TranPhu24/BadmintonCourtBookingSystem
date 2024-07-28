package group6.pojo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STAFF")
public class Staff {

    @Id
    @Column(name = "StaffID")
    private String staffId;

    @Column(name = "staffName")
    private String staffName;

    @OneToOne
    @JoinColumn(name = "UserId", unique = true)
    private User user;
    
    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Slot> slots=new HashSet<Slot>();
    
    public Staff() {
        super();
    }

    public Staff(String staffId, String staffName) {
        super();
        this.staffId = staffId;
        this.staffName = staffName;
    }
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Slot> getSlots() {
		return slots;
	}

	public void setSlots(Set<Slot> slots) {
		this.slots = slots;
	}

	public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
