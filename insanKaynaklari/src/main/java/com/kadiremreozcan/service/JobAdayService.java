package com.kadiremreozcan.service;

import java.util.ArrayList;

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

	// CREATE
	public long createBasvuru(JobAday basvuru) {

		return jobAdayDAO.insert(basvuru);
	}

	// UPDATE
	public Long updateBasvuru(JobAday basvuru) {

		jobAdayDAO.update(basvuru);

		// TODO:Neden 1l yollandý
		return 1l;
	}

	// READ bir adayýn basvurularýný döndürüyor
	public ArrayList<JobAday> getAllApplicationOfOneAday(Long aday_id) {

		return (ArrayList<JobAday>) jobAdayDAO.getOneAdayApplications(aday_id);
	}

}
