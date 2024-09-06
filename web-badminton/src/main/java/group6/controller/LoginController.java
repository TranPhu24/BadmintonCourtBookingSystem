package group6.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import group6.dto.AdminDTO;
import group6.dto.CustomerDTO;
import group6.dto.ManagerDTO;
import group6.dto.StaffDTO;
import group6.dto.UserDTO;
import group6.pojo.Manager;
import group6.pojo.Staff;
import group6.pojo.User;
import group6.service.AdminService;
import group6.service.CustomerService;
import group6.service.ManagerService;
import group6.service.StaffService;
import group6.service.UserService;

@Controller
public class LoginController {
	private final UserService userService;
	private final CustomerService customerService;
	private final AdminService adminService;
	private final StaffService staffService;
	private final ManagerService managerService;

    @Autowired
    public LoginController(UserService userService,CustomerService customerService,AdminService adminService,StaffService staffService,ManagerService managerService) {
        this.userService = userService;
        this.customerService=customerService;
        this.adminService=adminService;
        this.staffService=staffService;
        this.managerService=managerService;
    }
	
    @PostConstruct
    public void init() {
        try {
            AdminDTO adminDTO = new AdminDTO("admin", "1");
            UserDTO userDTO1 = new UserDTO("s1","staff1","1","staff","admin");
            UserDTO userDTO2 = new UserDTO("m2","manager2","1","manager","admin");
            adminService.createAdmin(adminDTO);
            
            StaffDTO  staffDTO = new StaffDTO("s1", "1","s1");
            userService.createUser(userDTO1);
            staffService.createStaff(staffDTO); 
            
            ManagerDTO  managerDTO = new ManagerDTO("m2", "2","m2");
            userService.createUser(userDTO2);
            managerService.createManager(managerDTO); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@RequestMapping(value = "/formRegister", method = RequestMethod.POST)
    public String formRegister(HttpServletRequest request, Model model) throws IOException {
        String btn = request.getParameter("btnRegister");

        if ("register".equals(btn)) {
        	String username = request.getParameter("username");
            String password = request.getParameter("password");
            String cccd = request.getParameter("cccd");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String name = request.getParameter("name");
            
          
            UserDTO userDTO = new UserDTO(username, name, password, "customer","admin");
            CustomerDTO customerDTO = new CustomerDTO(cccd, name, email, phone,0, username);            
            userService.createUser(userDTO);
            customerService.createCustomer(customerDTO);
            return "redirect:/form_login";
        }
        return "redirect:/";
    }
	@RequestMapping(value = "/formLoginCustomer", method = RequestMethod.POST)
    public String formLoginCustomer(HttpServletRequest request, Model model) throws IOException {
        String btn = request.getParameter("btnLogin");
        if ("login".equals(btn)) {
        	String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userService.getUser(username);
            
            if (user != null&&user.getPassword().equals(password)&& user.getRole().equals("customer") ) {
                request.getSession().setAttribute("userSession", user);
        		return "dat-san";
            }else {
            	model.addAttribute("errorMessage", "login-customer-false");
                return "redirect:/form_login";
			}
        }
        return "form_login";
        
	}
	/*                                  EMPLOYeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeê*/
	@RequestMapping(value = "/formLoginStaff", method = RequestMethod.POST)
	public String formLoginStaff(HttpServletRequest request, Model model) throws IOException {
		String btn = request.getParameter("btnLogin");
		if ("login".equals(btn)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = userService.getUser(username);
			Staff staff = staffService.getStaff(user.getUserID());
			
			if ((user != null || staff!=null)&&user.getRole().equals("staff")&&user.getPassword().equals(password)) {
				request.getSession().setAttribute("staffSession", staff);
	            request.getSession().setAttribute("userSession", user);
				model.addAttribute("id", user.getUserID());
                model.addAttribute("cccd", staff.getStaffId());
                model.addAttribute("name", staff.getStaffName());
                model.addAttribute("role", user.getRole());
				return "Staff_IF";
				}
			}else {
				model.addAttribute("errorMessage", "login-staff-false");
				return "redirect:/form_Employe_login";
			}
		return "form_Employe_login";
		
	}
	@RequestMapping(value = "/formLoginManager", method = RequestMethod.POST)
	public String formLoginManager(HttpServletRequest request, Model model) throws IOException {
		String btn = request.getParameter("btnLogin");
		if ("login".equals(btn)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = userService.getUser(username);
			Manager manager = managerService.getManager(user.getUserID());
			if (user != null&&user.getPassword().equals(password)&&user.getRole().equals("manager")) {
	            request.getSession().setAttribute("managerSession", manager);
	            request.getSession().setAttribute("userSession", user);
	            model.addAttribute("id", user.getUserID());
	            model.addAttribute("cccd", manager.getManagerId());
	            model.addAttribute("name", manager.getManagerName());
	            model.addAttribute("role", user.getRole());
				return "Manager_IF";
			}else {
				model.addAttribute("errorMessage", "login-manager-false");
				return "redirect:/form_Employe_login";
			}
			
		}
		return "form_Employe_login";
	}
	@RequestMapping(value = "/Manager_IF", method = RequestMethod.GET)
    public String Manager_IF(HttpServletRequest request,Model model) {
    	Manager managerSession = (Manager) request.getSession().getAttribute("managerSession");
    	User userrSession = (User) request.getSession().getAttribute("userSession");
		model.addAttribute("id", userrSession.getUserID());
        model.addAttribute("cccd", managerSession.getManagerId());
        model.addAttribute("name", managerSession.getManagerName());
        model.addAttribute("role", userrSession.getRole());
    	return "Manager_IF";
    }
	@RequestMapping(value = "/Staff_IF", method = RequestMethod.GET)
	public String Staff_IF(HttpServletRequest request,Model model) {
		Staff staffSession = (Staff) request.getSession().getAttribute("staffSession");
		User userrSession = (User) request.getSession().getAttribute("userSession");
		model.addAttribute("id", userrSession.getUserID());
		model.addAttribute("cccd", staffSession.getStaffId());
		model.addAttribute("name", staffSession.getStaffName());
		model.addAttribute("role", userrSession.getRole());
		return "Staff_IF";
	}
}
