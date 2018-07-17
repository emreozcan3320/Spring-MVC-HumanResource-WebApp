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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kadiremreozcan.entity.Jobs;
import com.kadiremreozcan.service.JobsService;
import com.kadiremreozcan.service.MailService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	private JobsService jobsService;
	
	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/anasayfa", method = RequestMethod.GET)
	public String anasayfa(Model model, HttpServletRequest req) {

		// System.out.println(req.getRemoteAddr());
		System.out.println("anasayfa");

		String name = "emre";
		model.addAttribute("name", name);

		return "anasayfa";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest req) {

		System.out.println("anasayfa");

		return "redirect:anasayfa";
	}
	
	/*@RequestMapping(value = "isveren/j_spring_security_check", method = RequestMethod.POST)
	public String adminForm(Model model, HttpServletRequest req) {

		System.out.println("isveren/j_spring_security_check");

		return "redirect:isveren/index";
	}*/

	// B�t�n ilanlar� d�n�yor
	@RequestMapping(value = "/ilanlar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ArrayList<Jobs>> ilanlar(HttpServletRequest request) {

		// System.out.println("/ilanlar :: post");

		return new ResponseEntity<>(jobsService.getAll(), HttpStatus.CREATED);
	}

	// Bir ilan�n bilgilerine bas�ld���nda d�nen sayfa
	@RequestMapping(value = "ilanlar/{id}", method = RequestMethod.GET)
	public String AnasayfailanBilgisi(@PathVariable("id") Long id, Model model) throws HibernateException, PropertyVetoException {

		System.out.println("ilanlar/" + id);
		model.addAttribute("ilan", jobsService.getJobById(id));
		//TODO: �lana ba�vurduysa ba�vurmamas� i�in model olu�turulacak

		return "ilanDetaylari";
	}

	@RequestMapping(value = "/ilanlar", method = RequestMethod.GET)
	public String ilanlar(Model model) throws HibernateException, PropertyVetoException {

		/*
		 * Jobs jobs = new Jobs(); jobs.setTitle("ilan3"); jobs.setStatus(true);
		 * jobs.setPersonal_qualities("kitap okuma,foto�raf��l�k");
		 * jobs.setJob_definition("junior java developer"); jobs.setIk_uzmani_id(null);
		 * jobs.setExpiration_date(null); jobs.setExpertise("java,python,hibarnate");
		 * jobs.setCreate_date(null); jobs.setActivation_date(null); jobs.setId(1l);
		 * 
		 * jobsService.createIlan(jobs);
		 */

		/*
		 * for(Ilanlar ilan : ilanlarService.getAll())
		 * System.out.println(ilan.getTitle());
		 */

		return "ilanlar";
	}

	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error_404(Model model) {

		return "error_404";
	}

	// @Autowired
	// private SessionFactory sessionFactory;

	

}
