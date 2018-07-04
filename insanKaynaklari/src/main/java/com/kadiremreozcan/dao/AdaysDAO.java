package com.kadiremreozcan.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadiremreozcan.entity.Adays;

@Repository
public class AdaysDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// CRUD i�lemleri yap�caz

	// CREAT
	public Long insert(Adays aday) {
		// save etti�inin id sini d�n�cek
		return (Long) sessionFactory.getCurrentSession().save(aday);
	}

	// UPDATE id olmak zorunda
	public void update(Adays aday) {
		sessionFactory.getCurrentSession().update(aday);
	}

	// PERSIST g�nderdi�in de�ere bak�yor varsa update ediyor yoksa create ediyor
	public void persist(Adays aday) {
		sessionFactory.getCurrentSession().persist(aday);
	}

	// DELETE id olmak zorunda
	public void delete(Adays aday) {
		sessionFactory.getCurrentSession().delete(aday);
	}

	// READ bir aday d�n�yor
	@SuppressWarnings("deprecation")
	public Adays getFindById(Long aday_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Adays  WHERE id=:aday_id").setLong("aday_id",
				aday_id);

		return (Adays) query.getSingleResult();
	}

	// READ b�t�n adaylar� d�n�yor
	@SuppressWarnings("unchecked")
	public ArrayList<Adays> getAll() {
		
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Adays");

		return (ArrayList<Adays>) query.getResultList();
	}

}
