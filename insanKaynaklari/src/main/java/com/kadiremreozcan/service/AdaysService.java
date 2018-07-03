package com.kadiremreozcan.service;

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
		// TODO:uzman id deðiþecek
		return adayDAO.insert(aday);
	}
	
	// READ bir adayýn bilgilerini dönüyor
	public Adays getAdayById(Long aday_id) {

			return adayDAO.getFindById(aday_id);
		}

}
