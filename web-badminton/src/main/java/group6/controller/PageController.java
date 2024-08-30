package group6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
    	System.out.print("letan");
        return "index";
    }
    @RequestMapping(value = "/dat-san", method = RequestMethod.GET)
    public String datSan() {
    	return "pages/dat-san";
    }
    @RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
    public String timKiem() {
    	return "pages/tim-kiem";
    }

    @RequestMapping(value = "/check-in", method = RequestMethod.GET)
    public String checkIn() {
        return "pages/check-in";
    }

    @RequestMapping(value = "/dang-ky-san", method = RequestMethod.GET)
    public String dangKySan() {
        return "pages/dang-ky-san";
    }

    @RequestMapping(value = "/quan-ly-chung", method = RequestMethod.GET)
    public String quanLyChung() {
        return "pages/quan-ly-chung";
    }

    @RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
    public String thanhToan() {
        return "pages/thanh-toan";
    }

    @RequestMapping(value = "/ve-chung-toi", method = RequestMethod.GET)
    public String veChungToi() {
        return "pages/ve-chung-toi";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "pages/login";
    }
    @RequestMapping(value = "/imprint", method = RequestMethod.GET)
    public String imprint() {
    	return "pages/imprint";
    }
    
    @RequestMapping(value = "/privacy-policy", method = RequestMethod.GET)
    public String privacyPolicy() {
    	return "pages/privacy-policy";
    }
    @RequestMapping(value = "/form_login", method = RequestMethod.GET)
    public String form_login() {
    	return "pages/form_login";
    }
    @RequestMapping(value = "/form_Employe_login", method = RequestMethod.GET)
    public String form_Employe_login() {
    	return "pages/form_Employe_login";
    }
    @RequestMapping(value = "/Staff_job", method = RequestMethod.GET)
    public String Staff_job() {
    	return "pages/Staff_job";
    }
    @RequestMapping(value = "/Manager_job", method = RequestMethod.GET)
    public String Manager_job() {
    	return "pages/Manager_job";
    }
    @RequestMapping(value = "/Staff_IF", method = RequestMethod.GET)
    public String Staff_IF() {
    	return "pages/Staff_IF";
    }
    @RequestMapping(value = "/Manager_IF", method = RequestMethod.GET)
    public String Manager_IF() {
    	return "pages/Manager_IF";
    }
}

