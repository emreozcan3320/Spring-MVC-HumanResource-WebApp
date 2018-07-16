 	package com.kadiremreozcan.dao;

import java.util.ArrayList;

import javax.persistence.NoResultException;
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

	// READ bir aday� linkedin_id ne g�re d�n�yor
		public Adays getFindByLinkedInId(String linkedin_id) {
			System.out.println("hibernate query �ncesi ::" + linkedin_id);
			
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Adays  WHERE linkedin_id=:linkedin_id").setParameter("linkedin_id",
					linkedin_id);
			try {
				return (Adays) query.getSingleResult();
			} catch (NoResultException  e) {
				Adays db_aday = new Adays();
				return db_aday;
			}
		}
		
	// READ b�t�n adaylar� d�n�yor
	@SuppressWarnings("unchecked")
	public ArrayList<Adays> getAll() {
		
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Adays");

		return (ArrayList<Adays>) query.getResultList();
	}

	//READ Bir ilana ba�vuran adaylar�n datas�n� d�n�yor
			@SuppressWarnings({ "deprecation", "unchecked" })
			public ArrayList<Adays> getOneApplicationAdayInfo(Long ilan_id){
			
			/*Query query = sessionFactory.getCurrentSession().createQuery("FROM JobAday WHERE aday_id=:aday_id ")
					.setLong("aday_id", aday_id);*/
				
			Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM adays,jobaday WHERE job_id=:ilan_id AND jobaday.aday_id = adays.id ")
					.setLong("ilan_id", ilan_id);
			
			return (ArrayList<Adays>) query.getResultList();
			
			}
}
