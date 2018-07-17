package com.kadiremreozcan.insanKaynaklari;

import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kadiremreozcan.entity.Adays;
import com.kadiremreozcan.entity.JobAday;
import com.kadiremreozcan.entity.Jobs;
import com.kadiremreozcan.service.JobAdayService;
import com.kadiremreozcan.service.JobsService;

@Controller
public class AdayController {
	
	/*
	 * ADAY ENDPOINTLERÝ BAÞLANGICI
	 * 
	 */
	@Autowired
	private JobAdayService jobAdayService;
	
	@Autowired
	private JobsService jobsService;
	

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
	public String adayBasvurular(Model model, HttpServletRequest request) throws HibernateException, PropertyVetoException {
		
		System.out.println("/aday/basvurular");
		
		Adays aday = (Adays) request.getSession().getAttribute("adaySession");
		ArrayList<JobAday> basvurular = jobAdayService.getAllApplicationOfOneAday(aday.getId());
		
		//System.out.println("/aday/basvurular :: arraylistsonrasý"+ basvurular);
		
		Jobs job = new Jobs();
		ArrayList<String> titles = new ArrayList<>();
		
		System.out.println("/aday/basvurular :: döngü öncesi");
		for (int i = 0; i < basvurular.size(); i++) {
			job = jobsService.getJobById(basvurular.get(i).getJob_id());
			titles.add("<tr>"
							+job.getTitle()+"</td>"
							+job.getJob_definition()+"</td>"
							+job.getPersonal_qualities()+"</td>"
							+job.getExpertise()+"</td>"
							+job.getCreate_date()+"</td>"
							+job.getActivation_date()+"</td>"
							+job.getExpiration_date()+"</td>"
							+job.isStatus()+"</td>"
							+basvurular.get(i).getBasvuru_statusu()+"</td>"
					+ "</tr>");
			

		}
		
		for (String num : titles) { 		      
	           System.out.println(num); 		
	      }
		
		System.out.println("/aday/basvurular :: döngü sonrasý");
		
		model.addAttribute("basvuru_tag", titles);
		
		return "basvurular";
	}

	/*
	 * ADAY ENDPOINTLERÝ BÝTÝÞÝ
	 * 
	 */

}
