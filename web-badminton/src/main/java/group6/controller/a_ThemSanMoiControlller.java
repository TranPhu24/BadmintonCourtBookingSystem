package group6.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import group6.dao.BookingDAO;
import group6.dto.BookingDTO;
import group6.pojo.Booking;
import group6.service.BookingService;

@Controller
public class a_ThemSanMoiControlller {
	private final BookingService bookingService;
	

    public a_ThemSanMoiControlller(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	@RequestMapping(value = "/Admin_add", method = RequestMethod.GET)
    public String Admin_add(HttpServletRequest request, Model model) {
    	List<Booking> listBooking= bookingService.findNoDate();
    	model.addAttribute("listBooking",listBooking);  
    	return "Admin_add";
    }
    @RequestMapping(value = "/bookingIdtoAdd", method = RequestMethod.GET)
    public String loadBookingToForm(@RequestParam("id") Long bookingId, HttpServletRequest request, Model model) {     
        List<Booking> listBooking= bookingService.findNoDate();
    	model.addAttribute("listBooking",listBooking);  
    	
        Booking booking = bookingService.getBooking(bookingId);
        model.addAttribute("booking", booking);
        request.getSession().setAttribute("bookingUpdate", booking);
        return "Admin_add";
    }

    @RequestMapping(value = "/updateBooking", method = RequestMethod.POST)
    public String updateBooking(HttpServletRequest request, Model model) {
    	Booking booking=(Booking)request.getSession().getAttribute("bookingUpdate");
    	String dateString = request.getParameter("date");
    	Date sqlDate = Date.valueOf(dateString);
    	
    	BookingDTO bookingDTO=new BookingDTO();
    	bookingDTO.setBookingType(booking.getBookingType());
    	bookingDTO.setBookingDay(booking.getBookingDay());
    	bookingDTO.setBookingDate(sqlDate);
    	bookingDTO.setCustomerId(booking.getCustomer().getCustomerId());
    	bookingDTO.setCourtId(booking.getCourt().getCourtId());
    	bookingDTO.setSlotId(booking.getSlot().getSlotId());
    	bookingDTO.setPaymentId(booking.getPayment().getPaymentId());
    	
    	bookingService.updateBooking(booking.getBookingId(),bookingDTO);
    	
    	
    	return "Admin_add";
    }
    
}
