package com.kadiremreozcan.insanKaynaklari;

import java.beans.PropertyVetoException;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdayController {
	
	/*
	 * ADAY ENDPOINTLER� BA�LANGICI
	 * 
	 */

	@RequestMapping(value = "/aday/login", method = RequestMethod.GET)
	public String adayLogin(Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/aday/login");

		return "adayLogin";
	}

	@RequestMapping(value = "/aday/index", method = RequestMethod.GET)
	public String aday(Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/aday/index");

		return "aday";
	}

	@RequestMapping(value = "/aday/basvurularim", method = RequestMethod.GET)
	public String adayBasvurular(Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/aday/basvurular");

		return "basvurular";
	}

	/*
	 * ADAY ENDPOINTLER� B�T���
	 * 
	 */

}
