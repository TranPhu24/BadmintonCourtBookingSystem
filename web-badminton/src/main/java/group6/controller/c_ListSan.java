package group6.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import group6.dao.BookingDAO;
import group6.pojo.Booking;
import group6.pojo.User;
import group6.service.BookingService;

@Controller
public class c_ListSan {
	private final BookingService bookingService;
    public c_ListSan(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	@RequestMapping(value = "/list-san-customer", method = RequestMethod.GET)
    public String listsancustomer(HttpServletRequest request,Model model) {
		User userrSession = (User) request.getSession().getAttribute("userSession");
		List<Booking> listBooking=bookingService.listCourtOfCustomer(userrSession.getCustomer().getCustomerId());
		model.addAttribute("listBooking",listBooking);
        return "list-san-customer";
    }
}
