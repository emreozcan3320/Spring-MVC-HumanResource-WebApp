package com.kadiremreozcan.service;

import java.util.ArrayList;

import javax.persistence.Query;

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

	public Long createIlan(Jobs ilan) {

		return ilanDAO.insert(ilan);
	}

	// READ
	public ArrayList<Jobs> getAll() {

		return ilanDAO.getAll();
	}

}
