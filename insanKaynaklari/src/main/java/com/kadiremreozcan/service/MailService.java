package com.kadiremreozcan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void redMail(String mailAdress,String ilan_name) {
	
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("appcoly@gmail.com");
		email.setTo(mailAdress);
		email.setSubject("Ýþ Baþvurusu Hakkýnda");
		email.setText("Bizimle ilgilendiðiniz için teþekkür ederiz.\n"+ilan_name+" isimli ilan baþvurunuz REDDEDÝLMÝÞTÝR");
		
		mailSender.send(email);
	}
	
	
	public void onayMail(String mailAdress, String ilan_name) {
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("appcoly@gmail.com");
		email.setTo(mailAdress);
		email.setSubject("Ýþ Baþvurusu Hakkýnda ( OLUMLU )");
		email.setText("Bizimle ilgilendiðiniz için teþekkür ederiz.\n"+ilan_name+" isimli ilan baþvurunuz KABUL EDÝLMÝÞTÝR");
		
		mailSender.send(email);
	}
}
