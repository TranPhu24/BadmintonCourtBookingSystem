package group6.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import group6.dto.BookingDTO;
import group6.dto.CustomerDTO;
import group6.pojo.Booking;
import group6.pojo.Court;
import group6.pojo.Customer;
import group6.pojo.Manager;
import group6.pojo.Slot;
import group6.pojo.Staff;
import group6.pojo.User;
import group6.service.BookingService;
import group6.service.CourtService;
import group6.service.CustomerService;
import group6.service.SlotService;
import net.bytebuddy.asm.Advice.Return;

@Controller
public class c_DatSanController {
	private final BookingService bookingService;
	private final SlotService slotService;
	private final CourtService courtService;
	private final CustomerService customerService;
	public c_DatSanController(BookingService bookingService, CourtService courtService,SlotService slotService,CustomerService customerService) {
		super();
		this.bookingService = bookingService;
		this.courtService = courtService;
		this.slotService = slotService;
		this.customerService = customerService;
	}
	
	@RequestMapping(value = "/dat-san", method = RequestMethod.GET)
	public String showListdatsan(HttpServletRequest request, Model model) {
        List<Slot> slotList = slotService.getAllSlots();
        List<Court> courts = courtService.getCourts();
        model.addAttribute("slots", slotList);
        model.addAttribute("courts", courts);
	    return "dat-san";
	}
	@RequestMapping(value = "/datsanCustomer", method = RequestMethod.POST)
	public String datsan(HttpServletRequest request, Model model) {
		String bookingType = request.getParameter("booking-type");
		BookingDTO bookingDTO=new BookingDTO();
		User userrSession = (User) request.getSession().getAttribute("userSession");
		String datsan=request.getParameter("datsan");
		if("datsan".equals(datsan)) {
			switch (bookingType) {
			case "fixed":
				String days = request.getParameter("fixed-days");
                String slotInfo = request.getParameter("slotInfo");
                String[] parts = slotInfo.split("-");
                Long courtId = Long.parseLong(parts[0]);
                Long slotId = Long.parseLong(parts[1]);	    
			    bookingDTO=new BookingDTO(bookingType,days,null,userrSession.getCustomer().getCustomerId(),courtId,slotId,null);     
				bookingService.createBooking(bookingDTO);
			    break;

			case "daily":
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
				
			    String slotInfo2 = request.getParameter("slotInfo");
                String[] parts2 = slotInfo2.split("-");
                Long courtId2 = Long.parseLong(parts2[0]);
                Long slotId2 = Long.parseLong(parts2[1]);	 
                
                bookingDTO=new BookingDTO(bookingType,null,sqlDate,userrSession.getCustomer().getCustomerId(),courtId2,slotId2,null);  
    			Booking booking = bookingService.createBooking(bookingDTO);
			    request.getSession().setAttribute("bookingSession", booking);
			    
			    
			    return "thanh-toan";

			case "flexible":
			    Customer customer= customerService.getCustomer(userrSession.getCustomer().getCustomerId());
			    float hours =  Float.parseFloat(request.getParameter("hours"))+customer.getTimeplay();
			    CustomerDTO customerDTO=new CustomerDTO();
			    customerDTO.setCustomerId(customer.getCustomerId());
			    customerDTO.setCustomerName(customer.getCustomerName());
			    customerDTO.setEmail(customer.getEmail());
			    customerDTO.setPhone(customer.getPhone());
			    customerDTO.setTimePlay(hours);
			    customerDTO.setUserId(userrSession.getUserID());
			    customerService.updateCustomer(customer.getCustomerId(),customerDTO);
			    
			    break;

			default:
			    model.addAttribute("error", "Loại đặt lịch không hợp lệ.");
			    return "dat-san";
			}
			
		}
		
		return "dat-san";
	}
	
	
	

	
}
