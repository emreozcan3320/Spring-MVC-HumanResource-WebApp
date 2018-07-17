package com.kadiremreozcan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadiremreozcan.dao.AdaysDAO;
import com.kadiremreozcan.entity.Adays;
import com.kadiremreozcan.entity.Jobs;

@Service
@Transactional
public class AdaysService {

	@Autowired
	private AdaysDAO adayDAO;

	// CREATE
	public Long createAday(Adays aday, HttpServletRequest req) {
		// TODO:uzman id deðiþecek
		return adayDAO.insert(aday);
	}

	// UPDATE
	public Long updateAday(Adays aday) {

		adayDAO.update(aday);

		// TODO:Neden 1l yollandý
		return 1l;
	}

	// READ bir adayýn bilgilerini dönüyor
	public Adays getAdayById(Long aday_id) {

		return adayDAO.getFindById(aday_id);
	}

	// READ bir adayýn linkedin id ne göre dönüyor bilgilerini dönüyor
	public Adays getAdayByLinkedInId(String linkedin_id) {

		return adayDAO.getFindByLinkedInId(linkedin_id);
	}

	// READ Bir ilana baþvuran adaylarýn datasýný dönüyor
	public ArrayList<Adays> getAdaysInfoForOneJob(Long job_id) {

		return adayDAO.getOneApplicationAdayInfo(job_id);
	}
}
