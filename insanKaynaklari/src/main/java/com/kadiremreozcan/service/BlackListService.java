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
		System.out.println("Service ::: aday id si ->"+list.getAday_id());
		return blackListDAO.insert(list);
	}

	// DELETE
	public void deleteBlackListed(Long aday_id) {

		blackListDAO.deleteByAdayId(aday_id);
	}

	// READ bir adayýn karaliste bilgisini dönüyor
	public BlackList getOneAdayBlackListInfo(Long aday_id) {

		return (BlackList) blackListDAO.getFindByAdayId(aday_id);
	}
}
