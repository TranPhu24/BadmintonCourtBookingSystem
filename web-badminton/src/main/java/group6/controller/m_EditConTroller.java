package group6.controller;

import java.sql.Time;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import group6.dto.CourtDTO;
import group6.dto.SlotDTO;
import group6.pojo.Court;
import group6.pojo.Slot;
import group6.service.CourtService;
import group6.service.SlotService;

@Controller
public class m_EditConTroller {
	private final CourtService courtService;
	private final SlotService slotService;
	
	@Autowired
	public m_EditConTroller(CourtService courtService, SlotService slotService) {
		super();
		this.courtService = courtService;
		this.slotService = slotService;
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
	
}
