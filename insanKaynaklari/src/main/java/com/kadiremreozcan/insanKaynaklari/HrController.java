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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kadiremreozcan.entity.Adays;
import com.kadiremreozcan.entity.JobAday;
import com.kadiremreozcan.entity.Jobs;
import com.kadiremreozcan.service.AdaysService;
import com.kadiremreozcan.service.JobAdayService;
import com.kadiremreozcan.service.JobsService;

@Controller
public class HrController {
	
	@Autowired
	private JobsService jobsService;
	
	@Autowired
	private AdaysService adaysService;
	
	@Autowired
	private JobAdayService jobAdayService;
	
	/*
	 * ÝÞVEREN ENDPOINTLERÝ BAÞLANGICI
	 * 
	 */

	// Ýsveren Login sayfasý
	@RequestMapping(value = "/isveren/login", method = RequestMethod.GET)
	public String isverenLogin(Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/login");

		return "isverenLogin";
	}

	// Ýsverenin ilk ulaþtýðý admin paneli
	@RequestMapping(value = "/isveren/index", method = RequestMethod.GET)
	public String isveren(Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/index");

		return "isveren";
	}

	// Ýþ verenin kendi verdiði ilanlarý görebildiði ve yönetebildiði sayfa
	@RequestMapping(value = "/isveren/ilan", method = RequestMethod.GET)
	public String isverenIlan(Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/ilan");

		// TODO:Burayý daha sonra login olan kiþiden alýcam
		model.addAttribute("ik_uzman_id", "1");

		return "isverenIlanYonetimi";
	}

	// Bir ilanýn bilgilerinin basýldýðý iþverenin ulaþabildiði sayfa
	@RequestMapping(value = "/isveren/ilan/{id}", method = RequestMethod.GET)
	public String ilanBilgi(@PathVariable("id") Long id, Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/ilan/" + id);
		model.addAttribute("ilan_id", id);

		return "ilanInfo";
	}

	// id si verilen bir ilanýn bilgilerini dönen endpoint
	@RequestMapping(value = "/isveren/ilanInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Jobs> isverenBirIlan(@RequestBody String ilan_id, HttpServletRequest request) {

		System.out.println("/isveren/ilanInfo :: post");

		return new ResponseEntity<>(jobsService.getJobById(Long.parseLong(ilan_id)), HttpStatus.CREATED);
	}

	// Bir iþverenin id si verildiðinde yayýnladýðý tüm ilanlarý dönen endpoint
	@RequestMapping(value = "/isveren/ilan", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ArrayList<Jobs>> isverenIlanlari(HttpServletRequest request) {

		System.out.println("/isveren/ilan :: post");

		return new ResponseEntity<>(jobsService.getAll(1l), HttpStatus.CREATED);
	}

	// Bir ilanýn editlemek için açýlan sayfa
	@RequestMapping(value = "/isveren/ilanEdit/{id}", method = RequestMethod.GET)
	public String ilanEdit(@PathVariable("id") Long id, Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/ilanEdit/" + id);

		model.addAttribute("ilan_id", id);

		return "ilanEdit";
	}

	// Editlenmiþ ilanýn update edildiði endpoint
	@RequestMapping(value = "/isveren/ilanEdit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> isverenIlanEdit(@RequestBody Jobs job, HttpServletRequest request) {

		System.out.println("/isveren/ilanEdit :: post");
		System.out.println(job.toString());

		Jobs oldJob = jobsService.getJobById(job.getId());
		oldJob.setTitle(job.getTitle());
		oldJob.setStatus(job.isStatus());
		oldJob.setExpertise(job.getExpertise());
		oldJob.setPersonal_qualities(job.getPersonal_qualities());
		oldJob.setJob_definition(job.getJob_definition());
		oldJob.setExpiration_date(job.getExpiration_date());
		oldJob.setActivation_date(job.getActivation_date());

		// System.out.println("*******************");
		// System.out.println(job.toString());
		// System.out.println("job activation date ->"+ job.getActivation_date());
		// System.out.println("job expiration date ->"+ job.getExpiration_date());
		// System.out.println("*******************");

		jobsService.updateIlan(oldJob, request);

		return new ResponseEntity<>("OK", HttpStatus.CREATED);
	}

	// Ýd si verilen ilaný silen endpoint
	@RequestMapping(value = "/isveren/ilanDelete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> isverenIlanDelete(@RequestBody Jobs job, HttpServletRequest request) {

		System.out.println("/isveren/ilanDelete :: post");
		// System.out.println(job.toString());

		Jobs oldJob = jobsService.getJobById(job.getId());

		// System.out.println("*******************");
		// System.out.println(job.toString());
		// System.out.println("job activation date ->"+ job.getActivation_date());
		// System.out.println("job expiration date ->"+ job.getExpiration_date());
		// System.out.println("*******************");

		jobsService.deleteIlan(oldJob, request);

		return new ResponseEntity<>("OK", HttpStatus.CREATED);
	}

	// Ýlan ekleme sayfasýný dönüyor
	@RequestMapping(value = "/isveren/ilanEkle", method = RequestMethod.GET)
	public String isverenIlanEkle(Model model) throws HibernateException, PropertyVetoException {

		return "ilanEkle";
	}

	// ilan ekleme sayfasýndan gelen bilgileri database yazýyor
	@RequestMapping(value = "/isveren/ilanEkle", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> isverenIlanEkle(@RequestBody Jobs job, HttpServletRequest request) {

		// System.out.println(job.toString());
		jobsService.createIlan(job, request);

		return new ResponseEntity<>("OK", HttpStatus.CREATED);
	}

	// iþverene aday bilgilerini dönen sayfa
	@RequestMapping(value = "/isveren/adayAra", method = RequestMethod.GET)
	public String adaySearch(Model model) throws HibernateException, PropertyVetoException {

		return "adaySearch";
	}
	
	///////////////
	
	@RequestMapping(value = "/isveren/adayInfo/{id}", method = RequestMethod.GET)
	public String adayInfo(@PathVariable("id") Long id, Model model) throws HibernateException, PropertyVetoException {
		
		System.out.println("/isveren/adayInfo/{id} :: get");
		
		/* Adays TABLOSU */
		Adays aday = new Adays();
		aday = adaysService.getAdayById(id);
		
		String arr1=aday.getSkills();
		String[] skillArray= arr1.split(",");
		
		String arr2=aday.getCourses();
		String[] coursesArray= arr2.split(",");
		
		System.out.println(aday.toString());
		
		model.addAttribute("aday", aday);
		model.addAttribute("adaySkills", skillArray);
		model.addAttribute("adayCourses", coursesArray);
		
		/*JobAday TABLOSU */
		model.addAttribute("basvurular", jobAdayService.getAllApplicationOfOneAday(id));
		
		
		
		return "adayInfo";
	}

	// id si verilen bir adayýn bilgilerini dönen endpoint
		/*@RequestMapping(value = "/isveren/adayInfo", method = RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<Adays> birAdayBilgisi(@RequestBody String aday_id, HttpServletRequest request) {

			System.out.println("/isveren/adayInfo :: post");
			
			

			return new ResponseEntity<>(adaysService.getAdayById(Long.parseLong(aday_id)), HttpStatus.CREATED);
		}*/

	/*
	 * ÝÞVEREN ENDPOINTLERÝ BÝTÝÞÝ
	 * 
	 */

}
