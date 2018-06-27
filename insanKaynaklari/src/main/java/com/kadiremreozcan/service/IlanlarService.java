package com.kadiremreozcan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadiremreozcan.dao.IlanlarDAO;
import com.kadiremreozcan.entity.Ilanlar;

@Service
@Transactional
public class IlanlarService {
	
	@Autowired
	private IlanlarDAO ilanDAO;
	
	public Long createIlan(Ilanlar ilan) {
		
		return ilanDAO.insert(ilan);
	}
	
}
