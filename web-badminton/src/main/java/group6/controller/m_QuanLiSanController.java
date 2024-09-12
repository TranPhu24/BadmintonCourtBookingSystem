package group6.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import group6.pojo.Booking;
import group6.pojo.Court;
import group6.pojo.User;
import group6.dto.CustomerDTO;
import group6.dto.ManagerDTO;
import group6.dto.StaffDTO;
import group6.dto.UserDTO;
import group6.service.BookingService;
import group6.service.CourtService;
import group6.service.CustomerService;
import group6.service.ManagerService;
import group6.service.StaffService;
import group6.service.UserService;

@Controller
public class m_QuanLiSanController {
	
	private final CourtService courtService;
	private final UserService userService;
	private final ManagerService managerService;
	private final CustomerService customerService;
	private final StaffService staffService;

    @Autowired
    public m_QuanLiSanController(ManagerService managerService,CourtService courtService,UserService userService,CustomerService customerService,StaffService staffService) {
        this.managerService=managerService;
        this.courtService=courtService;
        this.userService=userService;
        this.customerService=customerService;
        this.staffService=staffService;
    }
    
    @RequestMapping(value = "/quan-ly-chung", method = RequestMethod.GET)
    public String quanlychungHt(HttpServletRequest request, Model model) {
    	List<User> users = userService.getAllUsers();
    	model.addAttribute("users", users);
    	
    	List<Court> courts = courtService.getCourts();
    	model.addAttribute("courts", courts);
    
    	return "quan-ly-chung";
    }
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String editCustomer(HttpServletRequest request, Model model) {
    	String add=request.getParameter("add");
    	String xacnhan=request.getParameter("xacnhan");
    	String userType = request.getParameter("user-type");

        if (userType == null || userType.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn vai trò người dùng.");
            return "them-tai-khoan";
        }

        switch (userType) {
            case "customer":
                String c_username = request.getParameter("c_username");
                String c_cccd = request.getParameter("c_cccd");
                String c_fullname = request.getParameter("c_fullname");
                String c_email = request.getParameter("c_email");
                String c_phone = request.getParameter("c_phone");
                float c_timeplay = Float.parseFloat(request.getParameter("c_timeplay"));
                String c_password = request.getParameter("c_password");
                CustomerDTO customerDTO=new CustomerDTO(c_cccd,c_fullname,c_email,c_phone,c_timeplay,c_username);
                UserDTO c_userDTO =new UserDTO(c_username,c_fullname,c_password,"customer","admin");
                try {
                    userService.createUser(c_userDTO);
                    customerService.createCustomer(customerDTO);
                    request.setAttribute("successMessage", "customer-true");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "customer-false");
                }
                
                break;
            case "manager":
            	String m_username = request.getParameter("m_username");
                String m_cccd = request.getParameter("m_cccd");
                String m_fullname = request.getParameter("m_fullname");
                String m_password = request.getParameter("m_password");
                ManagerDTO managerDTO=new ManagerDTO(m_cccd,m_fullname,m_username);
                UserDTO m_userDTO =new UserDTO(m_username,m_fullname,m_password,"manager","admin");
                try {
                    userService.createUser(m_userDTO);
                    managerService.createManager(managerDTO);
                    request.setAttribute("successMessage", "manager-true");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "manager-false");
                }
                break;
            case "staff":
            	String s_username = request.getParameter("s_username");
                String s_cccd = request.getParameter("s_cccd");
                String s_fullname = request.getParameter("s_fullname");
                String s_password = request.getParameter("s_password");
                StaffDTO staffDTO=new StaffDTO(s_cccd,s_fullname,s_username);
                UserDTO s_userDTO =new UserDTO(s_username,s_fullname,s_password,"staff","admin");
                try {
                    userService.createUser(s_userDTO);
                    staffService.createStaff(staffDTO);
                    request.setAttribute("successMessage", "staff-true");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "staff-false");
                }
                break;
            default:
                model.addAttribute("error", "Vai trò không hợp lệ.");
                return "them-tai-khoan";
        }
    	
    	
    	
    	if("add".equals(add)) {
    		return "them-tai-khoan";
    	}
    	return "them-tai-khoan";
    }
    
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") String userId,Model model) {
        try {
            userService.deleteUser(userId);
        } catch (Exception e) {
        	model.addAttribute("error", "Vai trò không hợp lệ.");
            e.printStackTrace();
        }
        return "redirect:/quan-ly-chung";
    }
    
    
}
