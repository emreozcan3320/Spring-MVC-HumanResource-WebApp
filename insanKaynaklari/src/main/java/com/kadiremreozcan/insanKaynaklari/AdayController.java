package com.kadiremreozcan.insanKaynaklari;

import java.beans.PropertyVetoException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdayController {
	
	/*
	 * ADAY ENDPOINTLERÝ BAÞLANGICI
	 * 
	 */

	

	@RequestMapping(value = "/aday/index", method = RequestMethod.GET)
	public String aday(Model model, HttpServletRequest request) throws HibernateException, PropertyVetoException {
		
		//model.addAttribute("session_aday_linkedInId", request.getAttribute("adaySession"));
		
		System.out.println("Bu aday session nudur --> "+request.getSession().getAttribute("adaySession"));

		System.out.println("/aday/index");

		return "aday";
	}
	
	@RequestMapping(value = "/aday/logout", method = RequestMethod.GET)
	public String adaylogout(Model model, HttpServletRequest request) throws HibernateException, PropertyVetoException {
		
		//model.addAttribute("session_aday_linkedInId", request.getAttribute("adaySession"));
		
		request.getSession().setAttribute("adaySession", null);

		System.out.println("/aday/logout");

		return "redirect:aday/login";
	}

	@RequestMapping(value = "/aday/basvurularim", method = RequestMethod.GET)
	public String adayBasvurular(Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/aday/basvurular");

		return "basvurular";
	}

	/*
	 * ADAY ENDPOINTLERÝ BÝTÝÞÝ
	 * 
	 */

}
