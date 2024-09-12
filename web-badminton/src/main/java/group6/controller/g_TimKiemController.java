package group6.controller;

import java.sql.Time;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import group6.dao.BookingDAO;
import group6.pojo.Booking;
import group6.pojo.Court;
import group6.pojo.Slot;
import group6.service.BookingService;
import group6.service.CourtService;
import group6.service.SlotService;

@Controller
public class g_TimKiemController {
	private final CourtService courtService;
	private final SlotService slotService;

	private final BookingService bookingService;

    @Autowired
    public g_TimKiemController(CourtService courtService,SlotService slotService,BookingService bookingService) {
        this.courtService=courtService;
        this.slotService=slotService;
		this.bookingService=bookingService;
    }
    

    @RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
    public String timKiem(HttpServletRequest request,Model model) {
    	List<Court>listCourt=courtService.getCourts();
    	
    	model.addAttribute("listCourt",listCourt);
    	
    	
    	return "tim-kiem";
    }
    @RequestMapping(value = "/timkiemGuest", method = RequestMethod.POST)
    public String timkiemGuest(HttpServletRequest request, Model model) {
    	List<Court>listCourt=courtService.getCourts();
    	model.addAttribute("listCourt",listCourt);

        String location = request.getParameter("location");

        String[] parts = location.split("-");
        Long courtId = Long.parseLong(parts[0]);
        Long slotId = Long.parseLong(parts[1]);
        

        Court court = courtService.findById(courtId);
        Slot slot = slotService.getSlot(slotId);    
        String btnkiemtra = request.getParameter("btnkiemtra");
        if ("kiemtra".equals(btnkiemtra)) {
            List<Booking> listSearch = bookingService.guestFind(
                court.getLocation(), 
                court.getStartTime(), 
                court.getEndTime(), 
                slot.getStartTime(), 
                slot.getEndTime()
            );
            model.addAttribute("listSearch", listSearch);
        }

        return "tim-kiem";
    }

}
