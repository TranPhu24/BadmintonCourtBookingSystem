package group6.dto;

import java.util.Set;

public class StaffDTO {
    private String staffId;
    private String staffName;
    private String userId;
    public StaffDTO() {
    }

    public StaffDTO(String staffId, String staffName, String user) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.userId = user;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String user) {
        this.userId = user;
    }

}
