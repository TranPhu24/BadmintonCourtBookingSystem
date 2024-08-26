package group6.dto;

public class UserDTO {
    private String userId;
    private String userName;
    private String password;
    private String role;
    private String adminId;

    public UserDTO() {
    }

    public UserDTO(String userId, String userName, String password, String role, String adminId) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.adminId = adminId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
