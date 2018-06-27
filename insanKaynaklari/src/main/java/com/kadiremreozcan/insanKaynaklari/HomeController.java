package com.kadiremreozcan.insanKaynaklari;


import java.beans.PropertyVetoException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
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
	
	//@Autowired
	//private SessionFactory sessionFactory;
	
	@RequestMapping(value = "/aday", method = RequestMethod.GET)
	public String aday(Model model) throws HibernateException, PropertyVetoException {
				
		return "aday";
	}
	
	@RequestMapping(value = "/ik-uzmani", method = RequestMethod.GET)
	public String ikUzmani(Model model) throws HibernateException, PropertyVetoException {
				
		return "ik-uzmani";
	}
	
	@RequestMapping(value = "/ilanlar", method = RequestMethod.GET)
	public String ilanlar(Model model) throws HibernateException, PropertyVetoException {
				
		return "ilanlar";
	}
	
	
	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error_404(Model model) {
		
		return "error_404";
	}
	
}
