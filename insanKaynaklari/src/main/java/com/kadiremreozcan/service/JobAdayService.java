package com.kadiremreozcan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadiremreozcan.dao.JobAdayDAO;
import com.kadiremreozcan.entity.JobAday;

@Service
@Transactional
public class JobAdayService {

	@Autowired
	private JobAdayDAO jobAdayDAO;
	
	//CREATE
	public long createBasvuru(JobAday basvuru, HttpServletRequest req) {
		
		return jobAdayDAO.insert(basvuru);
	}
	
	//READ bir aday�n basvurular�n� d�nd�r�yor
	public ArrayList<JobAday> getAllApplicationOfOneAday(Long aday_id){
		
		return jobAdayDAO.getOneAdayApplications(aday_id);
	}
	
	
}
