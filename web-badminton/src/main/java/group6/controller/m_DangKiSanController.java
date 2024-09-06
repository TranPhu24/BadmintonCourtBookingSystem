package group6.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import group6.dao.CourtDAO;
import group6.dto.CourtDTO;
import group6.pojo.Booking;
import group6.pojo.Court;
import group6.pojo.Manager;
import group6.pojo.User;
import group6.service.CourtService;
import group6.service.ManagerService;

@Controller
public class m_DangKiSanController {
	private final CourtService courtService;

    @Autowired
    public m_DangKiSanController(CourtService courtService) {
        this.courtService=courtService;
    }
    
    
	
    @RequestMapping(value = "/dangkiManager", method = RequestMethod.POST)
    public String dangkiManager(HttpServletRequest request, Model model) throws IOException {

    	String location = request.getParameter("court-location");
        String startTimeStr = request.getParameter("fixed-start-time");
        String endTimeStr = request.getParameter("fixed-end-time");
        String priceStr = request.getParameter("price");
        Time startTime = Time.valueOf(startTimeStr + ":00");
        Time endTime = Time.valueOf(endTimeStr + ":00");
        float price = Float.parseFloat(priceStr);
        Manager managerSession = (Manager) request.getSession().getAttribute("managerSession");
        String btnDangki = request.getParameter("btndangki");

        if (btnDangki.equals("dangki")) {
            CourtDTO courtDTO = new CourtDTO(location, startTime, endTime, price, null,managerSession.getManagerId());
            courtService.createCourt(courtDTO);
        }

    	List<Court> courtList = courtService.getCourts();
        model.addAttribute("courtList", courtList);
        return "dang-ky-san";
    }
       	
    @RequestMapping(value = "/deleteCourt", method = RequestMethod.GET)
    public String deleteCourt(@RequestParam("id") Long courtId, Model model) {
        courtService.deleteCourt(courtId);
        List<Court> courtList = courtService.getCourts();
        model.addAttribute("courtList", courtList);
        return "dang-ky-san";
    }
    
    @RequestMapping(value = "/editCourt", method = {RequestMethod.GET})
	public String editCourt(@RequestParam("id") Long courtId,HttpServletRequest request, Model model) {
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
    public String formsuacourt(HttpServletRequest request, Model model) {
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
    
    /*----------------------------------------------------------------------*/
    @RequestMapping(value = "/dang-ky-san", method = RequestMethod.GET)
    public String dangKySan(Model model) {
        List<Court> courtList = courtService.getCourts();
    	model.addAttribute("courtList", courtList);
        return "dang-ky-san";
    }
    
    

}
