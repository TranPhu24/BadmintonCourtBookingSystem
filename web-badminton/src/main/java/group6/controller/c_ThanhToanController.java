package group6.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import group6.dao.BookingDAO;
import group6.dto.BookingDTO;
import group6.dto.CustomerDTO;
import group6.dto.PaymentDTO;
import group6.pojo.Booking;
import group6.pojo.Court;
import group6.pojo.Customer;
import group6.pojo.Payment;
import group6.pojo.Slot;
import group6.pojo.User;
import group6.service.BookingService;
import group6.service.CustomerService;
import group6.service.PaymentService;

@Controller
public class c_ThanhToanController {
	private final BookingService bookingService;
	private final PaymentService paymentService;
	private final CustomerService customerService;
	
	@Autowired
	public c_ThanhToanController(PaymentService paymentService,CustomerService customerService,BookingService bookingService) {
		super();
		this.paymentService = paymentService;
		this.customerService=customerService;
		this.bookingService=bookingService;
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
    public String thanhToan(HttpServletRequest request, Model model) {
		User userrSession = (User) request.getSession().getAttribute("userSession");
		List<Booking> listBooking = bookingService.findNoPayment(userrSession.getCustomer().getCustomerId()); 
		model.addAttribute("listBooking", listBooking);
	    return "thanh-toan";
    }
	
	
	@RequestMapping(value = "/form_thanhtoan", method = RequestMethod.GET)
	public String thanhToanfo(@RequestParam("id") Long bookingId,HttpServletRequest request, Model model) {
		Booking booking = bookingService.getBooking(bookingId); 
        model.addAttribute("booking", booking);
        
	    Slot slot=booking.getSlot();
	    Court court=booking.getCourt();       
	    
	    model.addAttribute("customerId",booking.getCustomer().getCustomerId());
	    model.addAttribute("timeOfBooking",slot.getStartTime()+"-"+slot.getEndTime());
	    model.addAttribute("amountType",booking.getBookingType());
	    model.addAttribute("location",court.getLocation());
	    Time startTime = slot.getStartTime();
	    Time endTime = slot.getEndTime();
	    LocalTime startLocalTime = startTime.toLocalTime();
	    LocalTime endLocalTime = endTime.toLocalTime();

	    Duration duration = Duration.between(startLocalTime, endLocalTime);
	    float hour = duration.toHours();
	    model.addAttribute("price",court.getPrice()*hour);
	    

    	PaymentDTO paymentDTO=new PaymentDTO(court.getPrice()*hour,LocalDate.now(),LocalTime.now(),"",booking.getCustomer().getCustomerId());
    	request.getSession().setAttribute("paymentDTO", paymentDTO);
    	request.getSession().setAttribute("booking", booking);
    	request.getSession().setAttribute("timePay", hour);
		return "form_thanhtoan";
	}
	
	@RequestMapping(value = "/formthanhtoanCustomer", method = RequestMethod.POST)
    public String formthanhToan(HttpServletRequest request, Model model) {
        PaymentDTO paymentDTO=(PaymentDTO)request.getSession().getAttribute("paymentDTO");
        Booking booking=(Booking)request.getSession().getAttribute("booking");
        
        String method=request.getParameter("payment-method");
        paymentDTO.setStatus(method);
        
	    String thanhtoan=request.getParameter("thanhtoan");
	    if("thanhtoan".equals(thanhtoan)) {
	    	if(method.equals("paypal")) {
	    		Customer customer = booking.getCustomer();
			    float hours =  customer.getTimeplay()-(Float)request.getSession().getAttribute("timePay");
			    CustomerDTO customerDTO=new CustomerDTO();
			    customerDTO.setCustomerId(customer.getCustomerId());
			    customerDTO.setCustomerName(customer.getCustomerName());
			    customerDTO.setEmail(customer.getEmail());
			    customerDTO.setPhone(customer.getPhone());
			    customerDTO.setTimePlay(hours);
			    customerDTO.setUserId(customer.getUser().getUserID());
			    customerService.updateCustomer(customer.getCustomerId(),customerDTO);
	    	}
	    	Payment payment = paymentService.createPayment(paymentDTO);
	    	
	    	BookingDTO bookingDTO =new BookingDTO();
	    	bookingDTO.setBookingDate(booking.getBookingDate());
	    	bookingDTO.setBookingDay(booking.getBookingDay());
	    	bookingDTO.setBookingType(booking.getBookingType());
	    	bookingDTO.setCourtId(booking.getCourt().getCourtId());
	    	bookingDTO.setCustomerId(booking.getCustomer().getCustomerId());
	    	bookingDTO.setPaymentId(payment.getPaymentId());
	    	bookingDTO.setSlotId(booking.getSlot().getSlotId());
	    	bookingService.updateBooking(booking.getBookingId(), bookingDTO);
	    	return "redirect:/thanh-toan";
	    }
        return "form_thanhtoan";
    }
	
}
