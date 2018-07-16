package com.kadiremreozcan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadiremreozcan.dao.AdaysDAO;
import com.kadiremreozcan.entity.Adays;

@Service
@Transactional
public class AdaysService {

	@Autowired
	private AdaysDAO adayDAO;

	// CREATE
	public Long createAday(Adays aday, HttpServletRequest req) {
		// TODO:uzman id de�i�ecek
		return adayDAO.insert(aday);
	}

	// READ bir aday�n bilgilerini d�n�yor
	public Adays getAdayById(Long aday_id) {

		return adayDAO.getFindById(aday_id);
	}

	// READ bir aday�n linkedin id ne g�re d�n�yor bilgilerini d�n�yor
	public Adays getAdayByLinkedInId(String linkedin_id) {

		return adayDAO.getFindByLinkedInId(linkedin_id);
	}
	
	//READ Bir ilana ba�vuran adaylar�n datas�n� d�n�yor
	public ArrayList<Adays> getAdaysInfoForOneJob(Long job_id) {

		return adayDAO.getOneApplicationAdayInfo(job_id);
	}
}
