package com.kadiremreozcan.insanKaynaklari;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Date;

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
import com.kadiremreozcan.service.MailService;

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
	
	@Autowired
	private MailService mailService;

	/*
	 * ��VEREN ENDPOINTLER� BA�LANGICI
	 * 
	 */

	// �sveren Login sayfas�
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

	// �sverenin ilk ula�t��� admin paneli
	@RequestMapping(value = "/isveren/index", method = RequestMethod.GET)
	public String isveren(Model model, HttpServletRequest request) throws HibernateException, PropertyVetoException {

		// System.out.println("Bu hr session nudur -->
		// "+request.getSession().getAttribute("hrSession"));

		System.out.println("/isveren/index");

		return "isveren";
	}

	// �sverenin ilk ula�t��� admin paneli
	@RequestMapping(value = "/isveren/success", method = RequestMethod.GET)
	public String isverenSucess(Model model, HttpServletRequest request)
			throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/success");

		return "isverenSuccess";
	}

	// id si verilen bir ilan�n bilgilerini d�nen endpoint
	@RequestMapping(value = "/isveren/adayValidate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HrStaffs> isverenValidate(@RequestBody String ldapUserName, HttpServletRequest request) {

		System.out.println("/isveren/adayValidate :: post");

		HrStaffs hrForSession = hrStaffService.getHrStaffByUserName(ldapUserName);
		request.getSession().setAttribute("hrSession", hrForSession);

		return new ResponseEntity<>(hrStaffService.getHrStaffByUserName(ldapUserName), HttpStatus.CREATED);
	}

	// �� verenin kendi verdi�i ilanlar� g�rebildi�i ve y�netebildi�i sayfa
	@RequestMapping(value = "/isveren/ilan", method = RequestMethod.GET)
	public String isverenIlan(Model model, HttpServletRequest request)
			throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/ilan");
		HrStaffs hrCurrent = (HrStaffs) request.getSession().getAttribute("hrSession");

		model.addAttribute("ik_uzman_id", hrCurrent.getId());

		return "isverenIlanYonetimi";
	}

	// Bir ilan�n bilgilerinin bas�ld��� i�verenin ula�abildi�i sayfa
	@RequestMapping(value = "/isveren/ilan/{id}", method = RequestMethod.GET)
	public String ilanBilgi(@PathVariable("id") Long id, Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/ilan/" + id);
		
		Jobs ilan = jobsService.getJobById(id);
		String uzmanlik = ilan.getExpertise();
		model.addAttribute("uzmanlik", uzmanlik);
		model.addAttribute("ilan_id", id);

		return "ilanInfo";
	}

	// id si verilen bir ilan�n bilgilerini d�nen endpoint
	@RequestMapping(value = "/isveren/ilanInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Jobs> isverenBirIlan(@RequestBody String ilan_id, HttpServletRequest request) {

		System.out.println("/isveren/ilanInfo :: post");

		return new ResponseEntity<>(jobsService.getJobById(Long.parseLong(ilan_id)), HttpStatus.CREATED);
	}

	// id si verilen bir ilana basvuranlar�n bilgilerini d�nen endpoint
	@RequestMapping(value = "/isveren/ilanBavuran", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ArrayList<Adays>> isverenBirIlanBasvuran(@RequestBody String job_id,
			HttpServletRequest request) {

		System.out.println("/isveren/ilanBavuran :: post");

		System.out.println(job_id);

		/*
		 * ArrayList<Adays> list =
		 * adaysService.getAdaysInfoForOneJob(Long.parseLong(job_id));
		 * System.out.println("Arraylist ge�ildi"); for (int i = 0; i < list.size();
		 * i++) { System.out.println(i); System.out.println(list.get(i).getName()); }
		 * System.out.println("Arraylist for d�ng�s� ge�ildi");
		 */
		return new ResponseEntity<>(adaysService.getAdaysInfoForOneJob(Long.parseLong(job_id)), HttpStatus.CREATED);
	}

	// Bir i�verenin id si verildi�inde yay�nlad��� t�m ilanlar� d�nen endpoint
	@RequestMapping(value = "/isveren/ilan", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ArrayList<Jobs>> isverenIlanlari(HttpServletRequest request) {

		System.out.println("/isveren/ilan :: post");

		HrStaffs hrCurrent = (HrStaffs) request.getSession().getAttribute("hrSession");
		
		ArrayList<Jobs> jobs = jobsService.getAll(hrCurrent.getId());
		for (int i = 0; i < jobs.size(); i++) { 	
			  //System.out.println("Activation Date ::: " + jobs.get(i).getTitle());
			  
			  Date activationDate = jobs.get(i).getActivation_date();
			  Date expirationDate = jobs.get(i).getExpiration_date();
			  Date todayDate = new Date();
			  
			  if(todayDate.after(activationDate)  ){
				     //System.out.println("�lan Aktif");
				     Jobs job = jobs.get(i);
					 job.setStatus(true);
					 jobsService.updateIlan(job);
				}
			  if(todayDate.after(expirationDate)){
					 //System.out.println("�lan pasif");
					 Jobs job = jobs.get(i);
					 job.setStatus(false);
					 jobsService.updateIlan(job);
				}
	          //System.out.println("Activation Date ::: " + jobs.get(i).getActivation_date());
	          //System.out.println("Expiration Date ::: " + jobs.get(i).getExpiration_date()); 
	      } 
		
		
		return new ResponseEntity<>(jobs, HttpStatus.CREATED);
	}

	// Bir ilan�n editlemek i�in a��lan sayfa
	@RequestMapping(value = "/isveren/ilanEdit/{id}", method = RequestMethod.GET)
	public String ilanEdit(@PathVariable("id") Long id, Model model) throws HibernateException, PropertyVetoException {

		System.out.println("/isveren/ilanEdit/" + id);

		model.addAttribute("ilan_id", id);

		return "ilanEdit";
	}

	// Editlenmi� ilan�n update edildi�i endpoint
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

		jobsService.updateIlan(oldJob);

		return new ResponseEntity<>("OK", HttpStatus.CREATED);
	}

	// �d si verilen ilan� silen endpoint
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

	// �lan ekleme sayfas�n� d�n�yor
	@RequestMapping(value = "/isveren/ilanEkle", method = RequestMethod.GET)
	public String isverenIlanEkle(Model model) throws HibernateException, PropertyVetoException {

		return "ilanEkle";
	}

	// ilan ekleme sayfas�ndan gelen bilgileri database yaz�yor
	@RequestMapping(value = "/isveren/ilanEkle", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> isverenIlanEkle(@RequestBody Jobs job, HttpServletRequest request) {

		// System.out.println(job.toString());
		System.out.println(job);
		Date create = job.getCreate_date();
		Date activate = job.getActivation_date();
		Date expiration = job.getExpiration_date();
		
		System.out.println("create ::: "+ create);
		System.out.println("activate ::: "+ activate);
		System.out.println("expiration ::: "+ expiration);
		
		jobsService.createIlan(job, request);

		return new ResponseEntity<>("OK", HttpStatus.CREATED);
	}

	// i�verene aday bilgilerini d�nen sayfa
	@RequestMapping(value = "/isveren/adayAra", method = RequestMethod.GET)
	public String adaySearch(Model model) throws HibernateException, PropertyVetoException {

		return "adaySearch";
	}

	///////////////

	@RequestMapping(value = "/isveren/adayInfo/{user_id}/{job_id}", method = RequestMethod.GET)
	public String adayInfo(@PathVariable("user_id") Long user_id, @PathVariable("job_id") Long job_id, Model model)
			throws HibernateException, PropertyVetoException {

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

		/* Basvuru Durumu */
		JobAday basvuruDurumAday = jobAdayService.getApplicationStatus(user_id, job_id);
		String ilanStatus = basvuruDurumAday.getBasvuru_statusu();
		Long ilanId = basvuruDurumAday.getJobaday_id();
		model.addAttribute("basvuru_id",ilanId);
		model.addAttribute("jobId", job_id);
		model.addAttribute("basvuru_durumu", ilanStatus);

		return "adayInfo";
	}

	// id si verilen bir aday� karalisteye ekliyen endpoint

	@RequestMapping(value = "/isveren/adayKaraListe", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> adayKaraListeEkle(@RequestBody BlackList list, HttpServletRequest request) {

		System.out.println("/isveren/adayInfo :: post");
		String islem = request.getHeader("islem");
		System.out.println("gelen i�lem header� ::: " + islem);

		if (islem.equals("add")) {

			// blaclist tablosuna ekliyor
			blackListService.createBlackListed(list);

			/* aday�n b�t�n i�lerini al�yor */
			Long karaListeliId = list.getAday_id();
			ArrayList<JobAday> basvurular = jobAdayService.getAllApplicationOfOneAday(karaListeliId);

			/*
			 * aday tablosundaki de�eri true yap�yor b�ylece karalistede oldu�unu anl�yoruz
			 */
			Adays aday = adaysService.getAdayById(karaListeliId);
			aday.setKaraListe(true);
			adaysService.updateAday(aday);

			/* B�t�n i� ba�vurular� red oluyor */
			for (int i = 0; i < basvurular.size(); i++) {
				// job = jobsService.getJobById(basvurular.get(i).getJob_id());
				JobAday basvuru = basvurular.get(i);
				basvuru.setBasvuru_statusu("red");
				jobAdayService.updateBasvuru(basvuru);
			}
		}

		if (islem.equals("remove")) {
			System.out.println("remove a girildi ");
			System.out.println("Controller ::: aday id si ->" + list.getAday_id());
			// blacklist tablosundan ��kar�yor

			blackListService.deleteBlackListed(list.getAday_id());

			/*
			 * aday tablosundaki de�eri FALSE yap�yor b�ylece karalisteden ��kt���n�
			 * anl�yoruz
			 */
			Long karaListeliId = list.getAday_id();
			Adays aday = adaysService.getAdayById(karaListeliId);
			aday.setKaraListe(false);
			adaysService.updateAday(aday);

			System.out.println("remove dan ��k�ld� ");
		}

		return new ResponseEntity<>("OK", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/isveren/adayBasvuruIslem", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> adayBasvuruIslem(@RequestBody JobAday basvuru, HttpServletRequest request) {
		
		System.out.println(basvuru);
		
		String islem = request.getHeader("islem");
		
		Long adayId = basvuru.getAday_id();
		Adays aday = adaysService.getAdayById(adayId);
		String eMail = aday.getEmail();
		
		Long ilanId = basvuru.getJob_id();
		Jobs job = jobsService.getJobById(ilanId);
		String jobName = job.getTitle();
		
		
		
		if (islem.equals("kabul")) {
			//System.out.println("islem kabul");
			basvuru.setBasvuru_statusu("kabul");
			jobAdayService.updateBasvuru(basvuru);
			
			mailService.onayMail(eMail, jobName);
		}

		if (islem.equals("red")) {
			//System.out.println("islem red");
			basvuru.setBasvuru_statusu("red");
			jobAdayService.updateBasvuru(basvuru);
			
			mailService.redMail(eMail, jobName);
		}

		
		// jobAdayService.createBasvuru(basvuru);

		return new ResponseEntity<>("OK", HttpStatus.CREATED);
	}

	/*
	 * ��VEREN ENDPOINTLER� B�T���
	 * 
	 */

}
