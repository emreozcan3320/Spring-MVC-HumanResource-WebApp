package com.kadiremreozcan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadiremreozcan.dao.HrStaffsDAO;
import com.kadiremreozcan.entity.HrStaffs;

@Service
@Transactional
public class HrStaffsService {
	
	@Autowired
	private HrStaffsDAO hrSataffsDAO;
	
	// READ bir adayýn bilgilerini dönüyor
		public HrStaffs getHrStaffById(Long uzman_id) {

				return hrSataffsDAO.getFindById(uzman_id);
			}

}
