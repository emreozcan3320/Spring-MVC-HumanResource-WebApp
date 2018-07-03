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
		
		//System.out.println(req.getRemoteAddr());
		System.out.println("anasayfa");
		
		String name = "emre";
		model.addAttribute("name", name );
		
		return "anasayfa";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest req) {
		
		System.out.println("anasayfa");
		
		return "redirect:anasayfa";
	}
	

	@RequestMapping(value = "/ilanlar", method = RequestMethod.GET)
	public String ilanlar(Model model) throws HibernateException, PropertyVetoException {
		
		/*
		Jobs jobs = new Jobs();
		jobs.setTitle("ilan3");
		jobs.setStatus(true);
		jobs.setPersonal_qualities("kitap okuma,foto�raf��l�k");
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
	
	//@Autowired
	//private SessionFactory sessionFactory;
	
	
	//==========================================================================//
	
	
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
	 * ADAY ENDPOINTLER� BA�LANGICI
	 * 
	*/
	
	//==========================================================================//
	
	/*
	 * ��VEREN ENDPOINTLER� BA�LANGICI
	 * 
	*/
	
	
	//�sveren Login sayfas�
	@RequestMapping(value = "/isveren/login", method = RequestMethod.GET)
	public String isverenLogin(Model model) throws HibernateException, PropertyVetoException {
			
		System.out.println("/isveren/login");
		
		return "isverenLogin";
	}
	
	//�sverenin ilk ula�t��� admin paneli
	@RequestMapping(value = "/isveren/index", method = RequestMethod.GET)
	public String isveren(Model model) throws HibernateException, PropertyVetoException {
		
		System.out.println("/isveren/index");
		
		return "isveren";
	}
	
	//�� verenin kendi verdi�i ilanlar� g�rebildi�i ve y�netebildi�i sayfa
	@RequestMapping(value = "/isveren/ilan", method = RequestMethod.GET)
	public String isverenIlan(Model model) throws HibernateException, PropertyVetoException {
		
		System.out.println("/isveren/ilan");
		
		//TODO:Buray� daha sonra login olan ki�iden al�cam
		model.addAttribute("ik_uzman_id","1");
				
		return "isverenIlanYonetimi";
	}
	
	//Bir ilan�n bilgilerinin bas�ld��� i�verenin ula�abildi�i sayfa
	@RequestMapping(value = "/isveren/ilan/{id}", method = RequestMethod.GET)
	public String ilanBilgi(@PathVariable("id") Long id, Model model) throws HibernateException, PropertyVetoException {
		
		System.out.println("/isveren/ilan/"+id);
		model.addAttribute("ilan_id",id);
				
		return "ilanInfo";
	}
	
	
	//id si verilen bir ilan�n bilgilerini d�nen endpoint
	@RequestMapping(value = "/isveren/ilanInfo", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<Jobs> isverenBirIlan(@RequestBody String ilan_id, HttpServletRequest request){
		
		System.out.println("/isveren/ilanInfo :: post");
		
		return new ResponseEntity<>(jobsService.getJobById(Long.parseLong(ilan_id)),HttpStatus.CREATED);
	}
	
	//Bir i�verenin id si verildi�inde yay�nlad��� t�m ilanlar� d�nen endpoint
	@RequestMapping(value = "/isveren/ilan", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<ArrayList<Jobs>> isverenIlanlari(HttpServletRequest request){
		
		System.out.println("/isveren/ilan :: post");
		
		return new ResponseEntity<>(jobsService.getAll(1l),HttpStatus.CREATED);
	}
	
	//Bir ilan�n editlemek i�in a��lan sayfa
	@RequestMapping(value = "/isveren/ilanEdit/{id}", method = RequestMethod.GET)
	public String ilanEdit(@PathVariable("id") Long id, Model model) throws HibernateException, PropertyVetoException {
		
		System.out.println("/isveren/ilanEdit/"+id);
		
		model.addAttribute("ilan_id",id);
				
		return "ilanEdit";
	}
	
	//Editlenmi� ilan�n update edildi�i endpoint
	@RequestMapping(value = "/isveren/ilanEdit/{id}", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<String> isverenIlanEdit(@RequestBody Jobs job, HttpServletRequest request){
		
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
		
		//System.out.println("*******************");
		//System.out.println(job.toString());
		//System.out.println("job activation date ->"+ job.getActivation_date());
		//System.out.println("job expiration date ->"+ job.getExpiration_date());
		//System.out.println("*******************");
		
		jobsService.updateIlan(oldJob, request);
		
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
	}
	
	//�d si verilen ilan� silen endpoint
	@RequestMapping(value = "/isveren/ilanDelete", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<String> isverenIlanDelete(@RequestBody Jobs job, HttpServletRequest request){
		
		System.out.println("/isveren/ilanDelete :: post");
		//System.out.println(job.toString());
		
		Jobs oldJob = jobsService.getJobById(job.getId());
		
		//System.out.println("*******************");
		//System.out.println(job.toString());
		//System.out.println("job activation date ->"+ job.getActivation_date());
		//System.out.println("job expiration date ->"+ job.getExpiration_date());
		//System.out.println("*******************");
		
		jobsService.deleteIlan(oldJob, request);
		
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
	}
	
	
	//�lan ekleme sayfas�n� d�n�yor
	@RequestMapping(value = "/isveren/ilanEkle", method = RequestMethod.GET)
	public String isverenIlanEkle(Model model) throws HibernateException, PropertyVetoException {
				
		return "ilanEkle";
	}
	
	//ilan ekleme sayfas�ndan gelen bilgileri database yaz�yor
	@RequestMapping(value = "/isveren/ilanEkle", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<String> isverenIlanEkle(@RequestBody Jobs job, HttpServletRequest request){
		
		
		//System.out.println(job.toString());
		jobsService.createIlan(job, request);
		
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
	}
	
	//i�verene aday bilgilerini d�nen sayfa
	@RequestMapping(value = "/isveren/adayInfo", method = RequestMethod.GET)
	public String adayInfo(Model model) throws HibernateException, PropertyVetoException {
				
		return "adayInfo";
	}
		
	
	/*
	 * ��VEREN ENDPOINTLER� B�T���
	 * 
	*/
	
	
	
}
