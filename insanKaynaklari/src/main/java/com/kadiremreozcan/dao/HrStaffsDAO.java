package com.kadiremreozcan.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadiremreozcan.entity.HrStaffs;

@Repository
public class HrStaffsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// READ id ye g�re bir HrStaff d�n�yor
	@SuppressWarnings("deprecation")
	public HrStaffs getFindById(Long uzman_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM HrStaffs  WHERE id=:uzman_id")
				.setLong("uzman_id", uzman_id);

		return (HrStaffs) query.getSingleResult();
	}

	// READ isme g�re bir HrStaff d�n�yor
	@SuppressWarnings("deprecation")
	public HrStaffs getFindByUserName(String uzman_name) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM HrStaffs  WHERE username=:uzman_name")
				.setString("uzman_name", uzman_name);

		return (HrStaffs) query.getSingleResult();
	}

	// READ b�t�n HrStaffs d�n�yor
	@SuppressWarnings("unchecked")
	public ArrayList<HrStaffs> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM HrStaffs");

		return (ArrayList<HrStaffs>) query.getResultList();
	}

}
