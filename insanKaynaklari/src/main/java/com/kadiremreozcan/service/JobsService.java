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

	// CREATE
	public Long createIlan(Jobs ilan, HttpServletRequest req) {
		// TODO:uzman id deðiþecek
		ilan.setIk_uzmani_id(1l);

		return ilanDAO.insert(ilan);
	}

	// READ bütün yayýnlanan iþleri dönüyor
	public ArrayList<Jobs> getAll() {

		return ilanDAO.getAll();
	}

	// READ bir isverenin yayýnladýðý iþleri dönüyor
	public ArrayList<Jobs> getAll(Long uzmanId) {

		return ilanDAO.getAll(uzmanId);
	}

	// READ bir iþin bilgilerini dönüyor
	public Jobs getJobById(Long job_id) {

		return ilanDAO.getFindById(job_id);
	}

	// UPDATE
	public Long updateIlan(Jobs ilan, HttpServletRequest req) {

		ilanDAO.update(ilan);

		// TODO:Neden 1l yollandý
		return 1l;
	}

	// DELETE
	public Long deleteIlan(Jobs ilan, HttpServletRequest req) {

		ilanDAO.delete(ilan);

		// TODO:Neden 1l yollandý
		return 1l;
	}

}
