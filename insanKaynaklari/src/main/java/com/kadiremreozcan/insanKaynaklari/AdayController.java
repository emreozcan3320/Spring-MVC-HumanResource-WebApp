package com.kadiremreozcan.insanKaynaklari;

import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kadiremreozcan.entity.Adays;
import com.kadiremreozcan.entity.JobAday;
import com.kadiremreozcan.entity.Jobs;
import com.kadiremreozcan.service.JobAdayService;
import com.kadiremreozcan.service.JobsService;

@Controller
public class AdayController {
	
	/*
	 * ADAY ENDPOINTLER� BA�LANGICI
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

		return "redirect:login";
	}

	@RequestMapping(value = "/aday/basvurularim", method = RequestMethod.GET)
	public String adayBasvurular(Model model, HttpServletRequest request) throws HibernateException, PropertyVetoException {
		
		System.out.println("/aday/basvurular");
		
		Adays aday = (Adays) request.getSession().getAttribute("adaySession");
		ArrayList<JobAday> basvurular = jobAdayService.getAllApplicationOfOneAday(aday.getId());
		
		//System.out.println("/aday/basvurular :: arraylistsonras�"+ basvurular);
		
		Jobs job = new Jobs();
		ArrayList<String> titles = new ArrayList<>();
		
		System.out.println("/aday/basvurular :: d�ng� �ncesi");
		for (int i = 0; i < basvurular.size(); i++) {
			job = jobsService.getJobById(basvurular.get(i).getJob_id());
			titles.add("<tr>"
							+"<td>"+job.getTitle()+"</td>"
							+"<td>"+job.getJob_definition()+"</td>"
							+"<td>"+job.getPersonal_qualities()+"</td>"
							+"<td>"+job.getExpertise()+"</td>"
							+"<td>"+job.getCreate_date()+"</td>"
							+"<td>"+job.getActivation_date()+"</td>"
							+"<td>"+job.getExpiration_date()+"</td>"
							+"<td>"+job.isStatus()+"</td>"
							+"<td>"+basvurular.get(i).getBasvuru_statusu()+"</td>"
					+ "</tr>");
			

		}
		
		for (String num : titles) { 		      
	           System.out.println(num); 		
	      }
		
		System.out.println("/aday/basvurular :: d�ng� sonras�");
		
		model.addAttribute("basvuru_tag", titles);
		
		return "basvurular";
	}
	
	@RequestMapping(value = "/aday/basvur", method = RequestMethod.POST) 
	 @ResponseBody public ResponseEntity<String> adaybasvuru(@RequestBody JobAday basvuru, HttpServletRequest request) {
	  
	 System.out.println("/aday/basvur :: post");
	 
	 //jobsService.createIlan(job, request);
	 
	 basvuru.setBasvuru_statusu("beklemede");
	 jobAdayService.createBasvuru(basvuru);
	  
	  
	 return new ResponseEntity<>("OK", HttpStatus.CREATED);
	 }
	
	

	/*
	 * ADAY ENDPOINTLER� B�T���
	 * 
	 */

}
