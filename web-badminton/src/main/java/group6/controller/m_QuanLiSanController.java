package group6.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import group6.pojo.Booking;
import group6.pojo.Court;
import group6.pojo.Customer;
import group6.pojo.User;
import group6.service.BookingService;
import group6.service.CourtService;
import group6.service.CustomerService;
import group6.service.ManagerService;
import group6.service.UserService;

@Controller
public class m_QuanLiSanController {
	private final ManagerService managerService;
	private final CourtService courtService;
	private final UserService userService;
	private final CustomerService customerService;

    @Autowired
    public m_QuanLiSanController(ManagerService managerService,CourtService courtService,UserService userService,CustomerService customerService) {
        this.managerService=managerService;
        this.courtService=courtService;
        this.userService=userService;
        this.customerService=customerService;
    }
    
    @RequestMapping(value = "/quan-ly-chung", method = RequestMethod.GET)
    public String quanlychungHt(HttpServletRequest request, Model model) {
    	List<User> users = userService.getAllUsers();
    	model.addAttribute("users", users);
    	
    	List<Court> courts = courtService.getCourts();
    	model.addAttribute("courts", courts);
        return "quan-ly-chung";
    }
}
