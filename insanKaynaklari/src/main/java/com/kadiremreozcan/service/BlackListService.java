package com.kadiremreozcan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadiremreozcan.dao.BlackListDAO;
import com.kadiremreozcan.entity.BlackList;

@Service
@Transactional
public class BlackListService {

	@Autowired
	private BlackListDAO blackListDAO;

	// CREATE
	public long createBlackListed(BlackList list) {

		return blackListDAO.insert(list);
	}

	// READ bir adayýn karaliste bilgisini dönüyor
	public BlackList getOneAdayBlackListInfo(Long aday_id) {

		return (BlackList) blackListDAO.getFindByAdayId(aday_id);
	}
}
