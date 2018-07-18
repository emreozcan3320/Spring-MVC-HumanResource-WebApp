package com.kadiremreozcan.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kadiremreozcan.entity.BlackList;

@Repository
@Transactional
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

	// DELETE id olmak zorunda
	@SuppressWarnings("deprecation")
	public void deleteByAdayId(Long aday_id) {

		// sessionFactory.getCurrentSession().delete(list);
		System.out.println("DAO ::: aday id si ->"+ aday_id);
		Query query = sessionFactory.getCurrentSession()
				.createSQLQuery("DELETE FROM BlackList WHERE aday_id =:aday_id ").setLong("aday_id", aday_id);
		query.executeUpdate();
	}

	// READ adayýn bilgisini dönüyor
	@SuppressWarnings("deprecation")
	public BlackList getFindByAdayId(Long aday_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM BlackList WHERE aday_id=:aday_id")
				.setLong("aday_id", aday_id);
		
		try {
			return (BlackList) query.getSingleResult();
		} catch (NoResultException e) {
			BlackList list = new BlackList();
			return list;
		}
	}
}
