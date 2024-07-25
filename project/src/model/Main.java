package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import model.*;


public class Main {
	
	public static ArrayList<Staff> getListStaff() {
        ArrayList<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM Staff";
        try (Connection connection = Database.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                String staffId = rs.getString("staffId");
                String staffName = rs.getString("staffName");
                staffList.add(new Staff(staffId, staffName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public static ArrayList<Admin> getListAD() {
        ArrayList<Admin> adList = new ArrayList<>();
        String sql = "SELECT * FROM s_AD";
        try (Connection connection = Database.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                String adId = rs.getString("adId");
                String adName = rs.getString("adName");
                adList.add(new Admin(adId, adName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adList;
    }

    public static ArrayList<Manager> getListManager() {
        ArrayList<Manager> managerList = new ArrayList<>();
        String sql = "SELECT * FROM Manager";
        try (Connection connection = Database.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                String managerId = rs.getString("managerId");
                String managerName = rs.getString("managerName");
                managerList.add(new Manager(managerId, managerName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managerList;
    }

    public static ArrayList<Customer> getListCustomer() {
        ArrayList<Customer> customerList = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        try (Connection connection = Database.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                String customerId = rs.getString("customerId");
                String customerName = rs.getString("customerName");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                customerList.add(new Customer(customerId, customerName, email, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static ArrayList<Account> getListAccount() {
        ArrayList<Account> accountList = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try (Connection connection = Database.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                String accountId = rs.getString("accountId");
                String userName = rs.getString("userName");
                String pass = rs.getString("pass");
                String roleL = rs.getString("roleL");
                accountList.add(new Account(accountId, userName, pass, roleL));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public static ArrayList<Court> getListCourt() {
        ArrayList<Court> courtList = new ArrayList<>();
        String sql = "SELECT * FROM Court";
        try (Connection connection = Database.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                String courtId = rs.getString("courtId");
                String locationL = rs.getString("locationL");
                String operatinghours = rs.getString("operatinghours");
                String price = rs.getString("price");
                courtList.add(new Court(courtId, locationL, operatinghours, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courtList;
    }

    public static ArrayList<Booking> getListBooking() {
        ArrayList<Booking> bookingList = new ArrayList<>();
        String sql = "SELECT * FROM Booking";
        try (Connection connection = Database.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                String bookingId = rs.getString("bookingId");
                String customerId = rs.getString("customerId");
                String bookingType = rs.getString("bookingType");
                Date bookingDate = rs.getDate("bookingDate");
                Time bookingTime = rs.getTime("bookingTime");
                bookingList.add(new Booking(bookingId, customerId, bookingType, bookingDate, bookingTime));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingList;
    }

    public static ArrayList<Payment> getListPayment() {
        ArrayList<Payment> paymentList = new ArrayList<>();
        String sql = "SELECT * FROM Payment";
        try (Connection connection = Database.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                String paymentId = rs.getString("paymentId");
                String customerId = rs.getString("customerId");
                float amount = rs.getFloat("amount");
                String statusL = rs.getString("statusL");
                paymentList.add(new Payment(paymentId, customerId, amount, statusL));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentList;
    }

    public static ArrayList<Slot> getListSlot() {
        ArrayList<Slot> slotList = new ArrayList<>();
        String sql = "SELECT * FROM Slot";
        try (Connection connection = Database.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                String slotId = rs.getString("slotId");
                String courtId = rs.getString("courtId");
                Time starttime = rs.getTime("starttime");
                Time endtime = rs.getTime("endtime");
                slotList.add(new Slot(slotId, courtId, starttime, endtime));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slotList;
    }
    public static void line() {
    	System.out.print("-----------------------------------------"+
    			"------------------------------------------------------------");
    }
	public static void main(String[] args) {
		ArrayList<Staff> dsStaff = getListStaff();
		ArrayList<Admin> dsAD = getListAD();
		ArrayList<Manager> dsManager = getListManager();
		ArrayList<Customer> dsCustomer = getListCustomer();
		ArrayList<Account> dsAccount = getListAccount();
		ArrayList<Court> dsCourt = getListCourt();
		ArrayList<Booking> dsBooking = getListBooking();
		ArrayList<Payment> dsPayment = getListPayment();
		ArrayList<Slot> dsSlot = getListSlot();
		for (Staff x : dsStaff) {System.out.println(x);}
		line();
		for (Admin x : dsAD) {System.out.println(x);}
		line();
		for (Manager x : dsManager) {System.out.println(x);}
		line();
		for (Customer x : dsCustomer) {System.out.println(x);}
		line();
		for (Account x : dsAccount) {System.out.println(x);}
		line();
		for (Court x : dsCourt) {System.out.println(x);}
		line();
		for (Booking x : dsBooking) { System.out.println(x);}
		line();
		for (Payment x : dsPayment) {System.out.println(x);}
		line();
		for (Slot x : dsSlot) {System.out.println(x);}
	}
}
