package com.kadiremreozcan.insanKaynaklari;


import java.beans.PropertyVetoException;

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

import com.kadiremreozcan.entity.Jobs;
import com.kadiremreozcan.service.JobsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private JobsService jobsService;
	
	
	@RequestMapping(value = "/anasayfa", method = RequestMethod.GET)
	public String anasayfa(Model model, HttpServletRequest req) {
		
		System.out.println(req.getRemoteAddr());
		
		String name = "emre";
		model.addAttribute("name", name );
		
		return "anasayfa";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest req) {
		
		return "redirect:anasayfa";
	}
	
	//@Autowired
	//private SessionFactory sessionFactory;
	
	@RequestMapping(value = "/aday/login", method = RequestMethod.GET)
	public String adayLogin(Model model) throws HibernateException, PropertyVetoException {
				
		return "adayLogin";
	}
	
	@RequestMapping(value = "/aday/index", method = RequestMethod.GET)
	public String aday(Model model) throws HibernateException, PropertyVetoException {
				
		return "aday";
	}
	
	@RequestMapping(value = "/aday/basvurular", method = RequestMethod.GET)
	public String adayBasvurular(Model model) throws HibernateException, PropertyVetoException {
				
		return "basvurular";
	}
	
	@RequestMapping(value = "/isveren/login", method = RequestMethod.GET)
	public String isverenLogin(Model model) throws HibernateException, PropertyVetoException {
				
		return "isverenLogin";
	}
	
	@RequestMapping(value = "/isveren/index", method = RequestMethod.GET)
	public String isveren(Model model) throws HibernateException, PropertyVetoException {
				
		return "isveren";
	}
	
	@RequestMapping(value = "/isveren/ilan", method = RequestMethod.GET)
	public String isverenIlan(Model model) throws HibernateException, PropertyVetoException {
				
		return "isverenIlanYonetimi";
	}
	
	@RequestMapping(value = "/isveren/ilanEkle", method = RequestMethod.GET)
	public String isverenIlanEkle(Model model) throws HibernateException, PropertyVetoException {
				
		return "ilanEkle";
	}
	@RequestMapping(value = "/isveren/ilanEkle", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<String> isverenIlanEkle(@RequestBody Jobs job, HttpServletRequest request){
		
		System.out.println(job.toString());
		//jobsService.createIlan(job, request);
		
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/isveren/adayInfo", method = RequestMethod.GET)
	public String adayInfo(Model model) throws HibernateException, PropertyVetoException {
				
		return "adayInfo";
	}
	
	
	
	@RequestMapping(value = "/ilanlar", method = RequestMethod.GET)
	public String ilanlar(Model model) throws HibernateException, PropertyVetoException {
		
		/*
		Jobs jobs = new Jobs();
		jobs.setTitle("ilan3");
		jobs.setStatus(true);
		jobs.setPersonal_qualities("kitap okuma,fotoðrafçýlýk");
		jobs.setJob_definition("junior java developer");
		jobs.setIk_uzmani_id(null);
		jobs.setExpiration_date(null);
		jobs.setExpertise("java,python,hibarnate");
		jobs.setCreate_date(null);
		jobs.setActivation_date(null);
		jobs.setId(1l);
		
		jobsService.createIlan(jobs);
		*/
		
		/*for(Ilanlar ilan : ilanlarService.getAll())
			System.out.println(ilan.getTitle());
		*/
		
		return "ilanlar";
	}
	
	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error_404(Model model) {
		
		return "error_404";
	}
	
}
