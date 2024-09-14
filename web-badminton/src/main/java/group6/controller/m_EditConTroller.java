package group6.controller;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import group6.dto.BookingDTO;
import group6.dto.CourtDTO;
import group6.dto.CustomerDTO;
import group6.dto.ManagerDTO;
import group6.dto.SlotDTO;
import group6.dto.StaffDTO;
import group6.dto.UserDTO;
import group6.pojo.Booking;
import group6.pojo.Court;
import group6.pojo.Customer;
import group6.pojo.Manager;
import group6.pojo.Slot;
import group6.pojo.User;
import group6.service.BookingService;
import group6.service.CourtService;
import group6.service.CustomerService;
import group6.service.ManagerService;
import group6.service.SlotService;
import group6.service.StaffService;
import group6.service.UserService;

@Controller
public class m_EditConTroller {
	private final CourtService courtService;
	private final SlotService slotService;
	private final UserService userService;
	private final ManagerService managerService;
	private final CustomerService customerService;
	private final StaffService staffService;
	private final BookingService bookingService;
	
	@Autowired
	public m_EditConTroller(BookingService bookingService,StaffService staffService,ManagerService managerService,CustomerService customerService,CourtService courtService, SlotService slotService,UserService userService) {
		super();
		this.courtService = courtService;
		this.slotService = slotService;
		this.userService = userService;
		this.managerService = managerService;
		this.customerService = customerService;
		this.staffService = staffService;
		this.bookingService = bookingService;
	}
	
	@RequestMapping(value = "/editCourt", method = {RequestMethod.GET})
	public String editCourt_(@RequestParam("id") Long courtId,HttpServletRequest request, Model model) {
		Court court = courtService.findById(courtId);
        model.addAttribute("courtId", court.getCourtId());
        model.addAttribute("location", court.getLocation());
        model.addAttribute("timestart", court.getStartTime());
        model.addAttribute("timeend", court.getEndTime());
        model.addAttribute("price", court.getPrice());
        
        request.getSession().setAttribute("courtUpdate",court);
		return "form_suasan";
	}
    @RequestMapping(value = "/formsuacourt", method = {RequestMethod.POST})
    public String formsuacourt_(HttpServletRequest request, Model model) {
    	Court court=(Court)request.getSession().getAttribute("courtUpdate");
    	String sua = request.getParameter("sua");
    	if("sua".equals(sua)) {
        	CourtDTO courtDTO=new CourtDTO();
        	courtDTO.setLocation(request.getParameter("location"));
        	courtDTO.setStartTime(Time.valueOf(request.getParameter("timestart")));
        	courtDTO.setEndTime(Time.valueOf(request.getParameter("timeend")));
        	courtDTO.setPrice( Float.parseFloat(request.getParameter("price")));
        	courtDTO.setManagerId(court.getManager().getManagerId());
        	courtService.updateCourt(court.getCourtId(), courtDTO);
        	return "redirect:/dang-ky-san";
        }
    	return "form_suasan";
    }
    
    @RequestMapping(value = "/editSlot", method = {RequestMethod.GET})
	public String editCourt(@RequestParam("id") Long slotId,HttpServletRequest request, Model model) {
		Slot slot = slotService.getSlot(slotId);
        model.addAttribute("slotId", slot.getSlotId());
        model.addAttribute("timestart", slot.getStartTime());
        model.addAttribute("timeend", slot.getEndTime());
        
        request.getSession().setAttribute("slotUpdate",slot);
		return "form_suaslot";
	}
    @RequestMapping(value = "/formsuaslot", method = {RequestMethod.POST})
    public String formsuacourt(HttpServletRequest request, Model model) {
    	Slot slot=(Slot)request.getSession().getAttribute("slotUpdate");
    	String sua = request.getParameter("sua");
    	if("sua".equals(sua)) {
        	SlotDTO slotDTO=new SlotDTO();
        	slotDTO.setStartTime(Time.valueOf(request.getParameter("timestart")));
        	slotDTO.setEndTime(Time.valueOf(request.getParameter("timeend")));
        	slotDTO.setManagerId(slot.getManager().getManagerId());
        	slotService.updateSlot(slot.getSlotId(), slotDTO);
        	return "redirect:/dang-ky-slot";
        }
    	return "form_suaslot";
    }
    
    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") String userId, HttpServletRequest request, Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("role", user.getRole());
        model.addAttribute("user", user);
                  
        request.getSession().setAttribute("userUpdate", user);
        return "form_suauser";
    }

    @RequestMapping(value = "/formsuauser", method = {RequestMethod.POST})
    public String formsuauser(HttpServletRequest request, Model model) {
    	User user=(User)request.getSession().getAttribute("userUpdate");
    	String xacnhan = request.getParameter("xacnhan");

    	if("xacnhan".equals(xacnhan)) {
    		switch (user.getRole()) {
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
                    userService.updateUser(c_username, c_userDTO);
                    customerService.updateCustomer(c_cccd, customerDTO);
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
                    userService.updateUser(m_username, m_userDTO);
                    managerService.updateManager(m_cccd, managerDTO);
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
                    userService.updateUser(s_username, s_userDTO);
                    staffService.updateStaff(s_cccd, staffDTO);
                    request.setAttribute("successMessage", "staff-true");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "staff-false");
                }
                break;
            default:
                model.addAttribute("error", "Vai trò không hợp lệ.");
                return "form_suause";
        }
    		return "redirect:/quan-ly-chung";
    	}
    	return "form_suauser";
    }
    
    @RequestMapping(value = "/editBooking", method = {RequestMethod.GET})
	public String editBooking(@RequestParam("id") Long bookingId,HttpServletRequest request, Model model) {
		Booking booking = bookingService.getBooking(bookingId);
		List<Court> courts = courtService.getCourts();
		model.addAttribute("courts", courts);
		model.addAttribute("booking", booking);
		
        request.getSession().setAttribute("bookingUpdate",booking);
		return "form_sualich";
	}
    
    @RequestMapping(value = "/formsuabooking", method = {RequestMethod.POST})
    public String formsuabooking(HttpServletRequest request, Model model) {
    	Booking booking=(Booking)request.getSession().getAttribute("bookingUpdate");
    	String sua = request.getParameter("sua");
    	if("sua".equals(sua)) {
    		String slotInfo = request.getParameter("slotInfo");
    		String bookingType = request.getParameter("booking-type");
    		String dateString = request.getParameter("daily-date");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate=null;
			try {
				utilDate = dateFormat.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
				utilDate = new java.util.Date();
			}
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    		
            String[] parts = slotInfo.split("-");
            Long courtId = Long.parseLong(parts[0]);
            Long slotId = Long.parseLong(parts[1]);	 
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setBookingType(bookingType);
            bookingDTO.setBookingId(booking.getBookingId());
            bookingDTO.setCourtId(courtId);
            bookingDTO.setSlotId(slotId);
            bookingDTO.setUserId(booking.getUser().getUserID());
            bookingDTO.setBookingDate(sqlDate);
            if(!bookingService.checkBooking(sqlDate, courtId, slotId)) {
            	bookingService.m_updateBooking(booking.getBookingId(), bookingDTO);
            	return "redirect:/dang-ky-lich";
        	}else {
        		model.addAttribute("error", "trung-lap");
        		return "redirect:/";
        	}	
        	
        }
    	return "redirect:/dang-ky-lich";
    }
	
}
