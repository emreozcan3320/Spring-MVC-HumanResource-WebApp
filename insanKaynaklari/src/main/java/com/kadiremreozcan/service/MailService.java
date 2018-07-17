package com.kadiremreozcan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void redMail(String mail,String ilan_name) {
	
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("appcoly@gmail.com");
		email.setTo(mail);
		email.setSubject("�� Ba�vurusu Hakk�nda");
		email.setText("Bizimle ilgilendi�iniz i�in te�ekk�r ederiz.\n"+ilan_name+" isimli ilan ba�vurunuz REDDED�LM��T�R");
		
		mailSender.send(email);
	}
	
	
	public void onayMail(String mail, String ilan_name) {
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("appcoly@gmail.com");
		email.setTo(mail);
		email.setSubject("�� Ba�vurusu Hakk�nda ( OLUMLU )");
		email.setText("Bizimle ilgilendi�iniz i�in te�ekk�r ederiz.\n"+ilan_name+" isimli ilan ba�vurunuz KABUL ED�LM��T�R");
		
		mailSender.send(email);
	}
}
