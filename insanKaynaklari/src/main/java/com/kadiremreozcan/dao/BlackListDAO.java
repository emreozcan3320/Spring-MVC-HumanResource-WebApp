package com.kadiremreozcan.dao;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadiremreozcan.entity.BlackList;

@Repository
public class BlackListDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// CREAT
	public Long insert(BlackList list) {

		return (Long) sessionFactory.getCurrentSession().save(list);
	}

	// UPDATE
	public void update(BlackList list) {
		sessionFactory.getCurrentSession().update(list);
	}

	// READ adayýn bilgisini dönüyor
	@SuppressWarnings("deprecation")
	public BlackList getFindByAdayId(Long aday_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM BlackList WHERE aday_id=:aday_id")
				.setLong("aday_id", aday_id);

		return (BlackList) query.getSingleResult();
	}
}
