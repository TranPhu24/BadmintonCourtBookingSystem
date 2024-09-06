package group6.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import group6.pojo.Booking;
import group6.pojo.Customer;
import group6.service.BookingService;

@Controller
public class s_CheckInController {
	private final BookingService bookingService;
	@Autowired
	public s_CheckInController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@RequestMapping(value = "/check-in", method = RequestMethod.GET)
    public String quanlychungHt(HttpServletRequest request, Model model) {
    	List<Booking> bookings = bookingService.getAllBookings();
    	model.addAttribute("bookingList", bookings);
        return "check-in";
    }
	
	@RequestMapping(value = "/checkinStaff", method = RequestMethod.POST)
	public String checkinStaff(HttpServletRequest request, Model model) {
		Long bookingId= Long.parseLong(request.getParameter("booking-id"));
		Booking booking = bookingService.getBooking(bookingId);
		model.addAttribute("booking", booking);
		List<Booking> bookings = bookingService.getAllBookings();
    	model.addAttribute("bookingList", bookings);
		return "check-in";
	}
	
	
}
