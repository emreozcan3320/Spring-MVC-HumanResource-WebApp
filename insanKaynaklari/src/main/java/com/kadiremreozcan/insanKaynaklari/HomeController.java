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

	// Bütün ilanlarý dönüyor
	@RequestMapping(value = "/ilanlar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ArrayList<Jobs>> ilanlar(HttpServletRequest request) {

		// System.out.println("/ilanlar :: post");

		return new ResponseEntity<>(jobsService.getAll(), HttpStatus.CREATED);
	}

	// Bir ilanýn bilgilerine basýldýðýnda dönen sayfa
	@RequestMapping(value = "ilanlar/{id}", method = RequestMethod.GET)
	public String AnasayfailanBilgisi(@PathVariable("id") Long id, Model model) throws HibernateException, PropertyVetoException {

		System.out.println("ilanlar/" + id);
		model.addAttribute("ilan", jobsService.getJobById(id));

		return "ilanDetaylari";
	}

	@RequestMapping(value = "/ilanlar", method = RequestMethod.GET)
	public String ilanlar(Model model) throws HibernateException, PropertyVetoException {

		/*
		 * Jobs jobs = new Jobs(); jobs.setTitle("ilan3"); jobs.setStatus(true);
		 * jobs.setPersonal_qualities("kitap okuma,fotoðrafçýlýk");
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

	// ==========================================================================//

	/*
	 * ADAY ENDPOINTLERÝ BAÞLANGICI
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
	 * ADAY ENDPOINTLERÝ BAÞLANGICI
	 * 
	 */

	// ==========================================================================//

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
	@RequestMapping(value = "/isveren/adayInfo", method = RequestMethod.GET)
	public String adayInfo(Model model) throws HibernateException, PropertyVetoException {

		return "adayInfo";
	}

	/*
	 * ÝÞVEREN ENDPOINTLERÝ BÝTÝÞÝ
	 * 
	 */

}
