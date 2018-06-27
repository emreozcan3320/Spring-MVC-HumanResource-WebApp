package com.kadiremreozcan.insanKaynaklari;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {
		
		System.out.println(req.getRemoteAddr());
		
		String name = "emre";
		model.addAttribute("name", name );
		
		return "home";
	}
	
	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error_404(Model model) {
		
		return "error_404";
	}
	
}
