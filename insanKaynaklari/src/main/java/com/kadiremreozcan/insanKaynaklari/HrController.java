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
import com.kadiremreozcan.entity.BlackList;
import com.kadiremreozcan.entity.HrStaffs;
import com.kadiremreozcan.entity.JobAday;
import com.kadiremreozcan.entity.Jobs;
import com.kadiremreozcan.service.AdaysService;
import com.kadiremreozcan.service.BlackListService;
import com.kadiremreozcan.service.HrStaffsService;
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
	
	@Autowired
	private HrStaffsService hrStaffService;
	
	@Autowired
	private BlackListService blackListService;

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

	/*
	 * //isveren logout
	 * 
	 * @RequestMapping(value = "/isveren/logout", method = RequestMethod.GET) public
	 * String isverenLogout(Model model) throws HibernateException,
	 * PropertyVetoException {
	 * 
	 * System.out.println("/isveren/logout");
	 * 
	 * return "redirect:../anasayfa"; }
	 */

	// Ýsverenin ilk ulaþtýðý admin paneli
	@RequestMapping(value = "/isveren/index", method = RequestMethod.GET)
	public String isveren(Model model, HttpServletRequest request) throws HibernateException, PropertyVetoException {
		
		//System.out.println("Bu hr session nudur --> "+request.getSession().getAttribute("hrSession"));
		
		System.out.println("/isveren/index");

		return "isveren";
	}

	// Ýsverenin ilk ulaþtýðý admin paneli
	@RequestMapping(value = "/isveren/success", method = RequestMethod.GET)
	public String isverenSucess(Model model, HttpServletRequest request)
			throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/success");

		return "isverenSuccess";
	}

	// id si verilen bir ilanýn bilgilerini dönen endpoint
	@RequestMapping(value = "/isveren/adayValidate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HrStaffs> isverenValidate(@RequestBody String ldapUserName, HttpServletRequest request) {

		System.out.println("/isveren/adayValidate :: post");
		
		HrStaffs hrForSession = hrStaffService.getHrStaffByUserName(ldapUserName);
		request.getSession().setAttribute("hrSession", hrForSession);

		return new ResponseEntity<>(hrStaffService.getHrStaffByUserName(ldapUserName), HttpStatus.CREATED);
	}

	// Ýþ verenin kendi verdiði ilanlarý görebildiði ve yönetebildiði sayfa
	@RequestMapping(value = "/isveren/ilan", method = RequestMethod.GET)
	public String isverenIlan(Model model, HttpServletRequest request) throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/ilan");
		HrStaffs hrCurrent =  (HrStaffs) request.getSession().getAttribute("hrSession");
		
		
		model.addAttribute("ik_uzman_id", hrCurrent.getId());

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

	// id si verilen bir ilana basvuranlarýn bilgilerini dönen endpoint
	@RequestMapping(value = "/isveren/ilanBavuran", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ArrayList<Adays>> isverenBirIlanBasvuran(@RequestBody String job_id,
			HttpServletRequest request) {

		System.out.println("/isveren/ilanBavuran :: post");

		System.out.println(job_id);

		/*
		 * ArrayList<Adays> list =
		 * adaysService.getAdaysInfoForOneJob(Long.parseLong(job_id));
		 * System.out.println("Arraylist geçildi"); for (int i = 0; i < list.size();
		 * i++) { System.out.println(i); System.out.println(list.get(i).getName()); }
		 * System.out.println("Arraylist for döngüsü geçildi");
		 */
		return new ResponseEntity<>(adaysService.getAdaysInfoForOneJob(Long.parseLong(job_id)), HttpStatus.CREATED);
	}

	// Bir iþverenin id si verildiðinde yayýnladýðý tüm ilanlarý dönen endpoint
	@RequestMapping(value = "/isveren/ilan", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ArrayList<Jobs>> isverenIlanlari(HttpServletRequest request) {

		System.out.println("/isveren/ilan :: post");
		
		HrStaffs hrCurrent =  (HrStaffs) request.getSession().getAttribute("hrSession");
		return new ResponseEntity<>(jobsService.getAll(hrCurrent.getId()), HttpStatus.CREATED);
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

	@RequestMapping(value = "/isveren/adayInfo/{user_id}/{job_id}", method = RequestMethod.GET)
	public String adayInfo(@PathVariable("user_id") Long user_id,@PathVariable("job_id") Long job_id, Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/adayInfo/{id} :: get");

		/* Adays TABLOSU */
		Adays aday = new Adays();
		aday = adaysService.getAdayById(user_id);

		String arr1 = aday.getSkills();
		String[] skillArray = arr1.split(",");

		String arr2 = aday.getCourses();
		String[] coursesArray = arr2.split(",");

		System.out.println(aday.toString());

		model.addAttribute("aday", aday);
		model.addAttribute("adaySkills", skillArray);
		model.addAttribute("adayCourses", coursesArray);

		ArrayList<JobAday> basvurular = jobAdayService.getAllApplicationOfOneAday(user_id);

		Jobs job = new Jobs();
		ArrayList<String> titles = new ArrayList<>();

		for (int i = 0; i < basvurular.size(); i++) {
			job = jobsService.getJobById(basvurular.get(i).getJob_id());
			titles.add("<tr><td><a href='/insanKaynaklari/isveren/ilan/" + job.getId() + "'>" + job.getTitle()
					+ "</a></td></tr>");
			// titles.add(job.getTitle());
			// System.out.println(basvurular.get(i).getJob_id());
		}

		model.addAttribute("basvuru_tag", titles);
		
		/*Basvuru Durumu */
		JobAday basvuruDurumAday = jobAdayService.getApplicationStatus(user_id, job_id);
		String ilanStatus = basvuruDurumAday.getBasvuru_statusu();
		model.addAttribute("basvuru_durumu", ilanStatus);
		
		return "adayInfo";
	}

	// id si verilen bir adayý karalisteye ekliyen endpoint
	
	 @RequestMapping(value = "/isveren/adayKaraListe", method = RequestMethod.POST) 
	 @ResponseBody public ResponseEntity<String> adayKaraListeEkle(@RequestBody BlackList list, HttpServletRequest request) {
	  
	 System.out.println("/isveren/adayInfo :: post");
	 String islem = request.getHeader("islem");
	 System.out.println("gelen iþlem headerý ::: "+islem);
	 
	 if(islem.equals("add")) {
		 
		 
		 //blaclist tablosuna ekliyor
		 blackListService.createBlackListed(list);
		 
		 /* adayýn bütün iþlerini alýyor*/
		 Long karaListeliId = list.getAday_id();
		 ArrayList<JobAday> basvurular = jobAdayService.getAllApplicationOfOneAday(karaListeliId);
		 
		 /* aday tablosundaki deðeri true yapýyor böylece karalistede olduðunu anlýyoruz*/
		 Adays aday = adaysService.getAdayById(karaListeliId);
		 aday.setKaraListe(true);
		 adaysService.updateAday(aday);
		 
		 /* Bütün iþ baþvurularý red oluyor*/
		 for (int i = 0; i < basvurular.size(); i++) {
				//job = jobsService.getJobById(basvurular.get(i).getJob_id());
			 	JobAday basvuru = basvurular.get(i);
			 	basvuru.setBasvuru_statusu("red");
			 	jobAdayService.updateBasvuru(basvuru);
			}
	 }
	 
	 if(islem.equals("remove")) {
		 System.out.println("remove a girildi ");
		 System.out.println("Controller ::: aday id si ->"+list.getAday_id());
		 //blacklist tablosundan çýkarýyor
		 
		 blackListService.deleteBlackListed(list.getAday_id());
		 
		 /* aday tablosundaki deðeri FALSE yapýyor böylece karalisteden çýktýðýný anlýyoruz*/
		 Long karaListeliId = list.getAday_id();
		 Adays aday = adaysService.getAdayById(karaListeliId);
		 aday.setKaraListe(false);
		 adaysService.updateAday(aday);
		 
		 System.out.println("remove dan çýkýldý ");
	 }
	 
	  
	 return new ResponseEntity<>("OK", HttpStatus.CREATED);
	 }
	 
	 @RequestMapping(value = "/isveren/adayKBasvuruIslem", method = RequestMethod.POST) 
	 @ResponseBody public ResponseEntity<String> adayBasvuruIslem(@RequestBody JobAday basvuru, HttpServletRequest request) {
		 
		 
		 return new ResponseEntity<>("OK", HttpStatus.CREATED);
	 }
	 
	 

	/*
	 * ÝÞVEREN ENDPOINTLERÝ BÝTÝÞÝ
	 * 
	 */

}
