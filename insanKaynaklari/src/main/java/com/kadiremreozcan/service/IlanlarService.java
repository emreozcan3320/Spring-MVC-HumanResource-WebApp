package com.kadiremreozcan.service;

import java.util.ArrayList;

import javax.persistence.Query;

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

	// READ
	public ArrayList<Ilanlar> getAll() {

		return ilanDAO.getAll();
	}

}
