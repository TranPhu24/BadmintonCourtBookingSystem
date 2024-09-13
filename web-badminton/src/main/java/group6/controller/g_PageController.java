package group6.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import group6.pojo.Court;

@Controller
public class g_PageController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/ve-chung-toi", method = RequestMethod.GET)
    public String veChungToi() {
        return "ve-chung-toi";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/imprint", method = RequestMethod.GET)
    public String imprint() {
    	return "imprint";
    }
    
    @RequestMapping(value = "/privacy-policy", method = RequestMethod.GET)
    public String privacyPolicy() {
    	return "privacy-policy";
    }
    @RequestMapping(value = "/form_login", method = RequestMethod.GET)
    public String form_login() {
    	return "form_login";
    }
    @RequestMapping(value = "/form_Employe_login", method = RequestMethod.GET)
    public String form_Employe_login() {
    	return "form_Employe_login";
    }
    @RequestMapping(value = "/Staff_job", method = RequestMethod.GET)
    public String Staff_job() {
    	return "Staff_job";
    }
    @RequestMapping(value = "/form_admin_login", method = RequestMethod.GET)
    public String form_admin_login() {
    	return "form_admin_login";
    }
    
   
}

