package group6.controller;

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
import group6.dto.CustomerDTO;
import group6.pojo.Booking;
import group6.pojo.Court;
import group6.pojo.Customer;
import group6.pojo.Manager;
import group6.pojo.User;
import group6.service.BookingService;
import group6.service.CourtService;
import group6.service.SlotService;

@Controller
public class m_DangKiLichControlller {
	private final BookingService bookingService;
	private final SlotService slotService;
	private final CourtService courtService;
	
	@Autowired
	public m_DangKiLichControlller(BookingService bookingService, SlotService slotService, CourtService courtService) {
		super();
		this.bookingService = bookingService;
		this.slotService = slotService;
		this.courtService = courtService;
	}
	@RequestMapping(value = "/dang-ky-lich", method = RequestMethod.GET)
	public String dangkylich(HttpServletRequest request, Model model) {
        List<Court> courts = courtService.getCourts();
        model.addAttribute("courts", courts);
        
        List<Booking>bookings=bookingService.findFight();
        model.addAttribute("bookings", bookings);
	    return "dang-ky-lich";
	}
	@RequestMapping(value = "/datsanManager", method = RequestMethod.POST)
	public String datsanManager(HttpServletRequest request, Model model) {
		String bookingType = request.getParameter("booking-type");	
		BookingDTO bookingDTO=new BookingDTO();
    	User userrSession = (User) request.getSession().getAttribute("userSession");
		String datsan=request.getParameter("datsan");
		if("datsan".equals(datsan)) {
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
			
		    String slotInfo = request.getParameter("slotInfo");
            String[] parts = slotInfo.split("-");
            Long courtId = Long.parseLong(parts[0]);
            Long slotId = Long.parseLong(parts[1]);	 
            bookingDTO=new BookingDTO(bookingType,null,sqlDate,userrSession.getUserID(),courtId,slotId,null);  
            if(!bookingService.checkBooking(sqlDate, courtId, slotId)) {
    			Booking booking = bookingService.createBooking(bookingDTO);
    			request.getSession().setAttribute("bookingSession", booking);
    		}
            else {
            	model.addAttribute("error", "trung-lap");
            }
		}
		
		return "redirect:/dang-ky-lich";
	}
	@RequestMapping(value = "/deleteBooking", method = RequestMethod.GET)
    public String deleteBooking(@RequestParam("id") Long bookingId, Model model) {
        bookingService.delete(bookingId);
        return "redirect:/dang-ky-lich";
    }
	
}
