package com.kadiremreozcan.insanKaynaklari;

import java.beans.PropertyVetoException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kadiremreozcan.entity.Adays;
import com.kadiremreozcan.service.AdaysService;

@Controller
public class LinkedInConnectController {

	@Autowired
	private AdaysService adaysService;

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
	public String getAttr(@RequestParam String code, @RequestParam String state, HttpServletRequest request)
			throws Exception {

		Post_Test obj_Post = new Post_Test();
		Adays linkedinAday = obj_Post.sendPost(code, redirect_url, client_id, client_secret);

		//System.out.println("================================================");

		//System.out.println((String) ("LinkedInControllerprofile line 49 :: " + linkedinAday));

		//System.out.println("================================================");

		//System.out.println("linkedin_id :: " + linkedinAday.getLinkedin_id());

		String LinkedinAday_id = linkedinAday.getLinkedin_id();

		Adays Db_aday = adaysService.getAdayByLinkedInId(LinkedinAday_id);
		System.out.println((String) ("Db_aday:::" + Db_aday));

		if (Db_aday.getLinkedin_id() == null) {

			Adays profile = new Adays();
			profile.setName(linkedinAday.getName());
			profile.setSurname(linkedinAday.getSurname());
			profile.setLinkedin_id(linkedinAday.getLinkedin_id());
			profile.setHeadline(linkedinAday.getHeadline());

			// System.out.println("Db den gelen :::" + Db_aday);
			// System.out.println("LinkedIn :::" + linkedinAday);
			// System.out.println("profile :::"+ profile);

			adaysService.createAday(profile, request);
			
			Adays New_aday = adaysService.getAdayByLinkedInId(linkedinAday.getName());
			System.out.println((String) ("New_aday :::" + New_aday));
			
			request.getSession().setAttribute("adaySession", New_aday);

		}else {
			request.getSession().setAttribute("adaySession", Db_aday);
		}
		
		
		
		return "linkedInSuccess";
	}

}
