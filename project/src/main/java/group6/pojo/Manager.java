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
@Table(name = "MANAGER")
public class Manager {

    @Id
    @Column(name = "ManagerID")
    private String managerId;

    @Column(name = "ManagerName")
    private String managerName;

    @OneToOne
    @JoinColumn(name = "UserId", unique = true)
    private User user;
    
    @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Court> courts = new HashSet<Court>();
    
    @OneToMany (mappedBy = "manager",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Slot>slots= new HashSet<Slot>();
    
    public Manager() {
        super();
    }

    public Manager(String managerId, String managerName) {
        super();
        this.managerId = managerId;
        this.managerName = managerName;
    }
    
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Court> getCourts() {
		return courts;
	}

	public void setCourts(Set<Court> courts) {
		this.courts = courts;
	}

	public Set<Slot> getSlots() {
		return slots;
	}

	public void setSlots(Set<Slot> slots) {
		this.slots = slots;
	}

	public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
