package group6.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import group6.repository.IUserRepository;
import group6.repository.UserRepository;

@Controller
public class HomeController {
	private IUserRepository iUserRepository;
	
	
	public HomeController() {
		iUserRepository = new UserRepository();
	}
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("index");
	}
	
	
}
