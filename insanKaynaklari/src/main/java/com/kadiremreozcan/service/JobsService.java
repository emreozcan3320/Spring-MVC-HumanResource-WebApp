package com.kadiremreozcan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadiremreozcan.dao.JobsDAO;
import com.kadiremreozcan.entity.Jobs;

@Service
@Transactional
public class JobsService {

	@Autowired
	private JobsDAO ilanDAO;

	public Long createIlan(Jobs ilan, HttpServletRequest req) {
		//TODO:uzman id de�i�ecek
		ilan.setIk_uzmani_id(1l);

		return ilanDAO.insert(ilan);
	}

	// READ b�t�n yay�nlanan i�leri d�n�yor
	public ArrayList<Jobs> getAll() {

		return ilanDAO.getAll();
	}
	
	// READ bir isverenin yay�nlad��� i�leri d�n�yor
	public ArrayList<Jobs> getAll(Long uzmanId) {

		return ilanDAO.getAll(uzmanId);
	}
	
	//READ bir i�in bilgilerini d�n�yor
	public Jobs getJobsById(Long job_id){
		
		return ilanDAO.getFindById(job_id);	
	}	

}
