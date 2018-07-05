package com.kadiremreozcan.insanKaynaklari;

import java.beans.PropertyVetoException;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LinkedInConnectController {

	String redirect_url = "http://localhost:8080/insanKaynaklari/linkedInSuccess";
	String client_id = "86dy01iuj8u89d";
	String client_secret = "k7lgIuxK6WYhXPzO";

	@RequestMapping(value = "/aday/login", method = RequestMethod.GET)
	public String adayLogin(Model model) throws HibernateException, PropertyVetoException {

		model.addAttribute("redirect_url", redirect_url);
		model.addAttribute("client_id", client_id);
		model.addAttribute("client_secret", client_secret);

		System.out.println("/aday/login");

		return "adayLogin";
	}

	@RequestMapping(value = "/linkedInSuccess", method = RequestMethod.GET)
	public String getAttr(@RequestParam String code, @RequestParam String state) throws Exception {

		/*
		 * @RequestMapping(value = "/linkedInSuccess", method = RequestMethod.GET)
		 * 
		 * @ResponseBody public String getAttr(@RequestParam String code, @RequestParam
		 * String state) throws Exception {
		 */

		Post_Test obj_Post = new Post_Test();
		String access_token = obj_Post.sendPost(code, redirect_url, client_id, client_secret);
		String profile = obj_Post.sendGet(access_token);

		// System.out.println("code:::"+code);
		System.out.println("profile :: " + profile);

		return "linkedInSuccess";
	}

}
