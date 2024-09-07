package group6.controller;

import java.io.IOException;
import java.sql.Time;
import java.util.List;

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
import group6.pojo.Manager;
import group6.pojo.Slot;
import group6.service.SlotService;

@Controller
public class m_DangKiSlotController {
	private final SlotService slotService;

    @Autowired
    public m_DangKiSlotController(SlotService slotService) {
        this.slotService=slotService;
    }
    
    @RequestMapping(value = "/dangkiSlotManager", method = RequestMethod.POST)
    public String dangkiSlotManager(HttpServletRequest request, Model model) throws IOException {

        String startTimeStr = request.getParameter("fixed-start-time");
        String endTimeStr = request.getParameter("fixed-end-time");
        
        Time startTime = Time.valueOf(startTimeStr + ":00");
        Time endTime = Time.valueOf(endTimeStr + ":00");
        Manager managerSession = (Manager) request.getSession().getAttribute("managerSession");
        String btnDangki = request.getParameter("btndangki");

        if (btnDangki.equals("dangki")) {
            SlotDTO slotDTO = new SlotDTO(startTime, endTime, managerSession.getManagerId(), null);
            slotService.createSlot(slotDTO);
        }

    	List<Slot> slotList = slotService.getAllSlots();
        model.addAttribute("slotList", slotList);
        return "dang-ky-slot";
    }
       	
    @RequestMapping(value = "/deleteSlot", method = RequestMethod.GET)
    public String deleteSlot(@RequestParam("id") Long slotId, Model model) {
    	slotService.deleteSlot(slotId);
    	List<Slot> slotList = slotService.getAllSlots();
        model.addAttribute("slotList", slotList);
        return "dang-ky-slot";
    }
    
    
    
    /*----------------------------------------------------------------------*/
    @RequestMapping(value = "/dang-ky-slot", method = RequestMethod.GET)
    public String dangKySlot(Model model) {
    	List<Slot> slotList = slotService.getAllSlots();
        model.addAttribute("slotList", slotList);
        return "dang-ky-slot";
    }
}
