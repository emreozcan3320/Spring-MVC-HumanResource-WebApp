package com.kadiremreozcan.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadiremreozcan.entity.ilanlar;

@Repository
public class ilanlarDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	//CRUD i�lemleri yap�caz
	
	//CREAT
	public Long insert(ilanlar ilan) {
		//save etti�inin id sini d�n�cek
		return (Long) sessionFactory.getCurrentSession().save(ilan);
	}
	
	//UPDATE id olmak zorunda
	public void update(ilanlar ilan) {
		sessionFactory.getCurrentSession().update(ilan);
	}
	
	//PERSIST g�nderdi�in de�ere bak�yor varsa update ediyor yoksa create ediyor
	public void persist(ilanlar ilan) {
		sessionFactory.getCurrentSession().persist(ilan);
	}
	
	//DELETE id olmak zorunda
	public void delete(ilanlar ilan) {
		sessionFactory.getCurrentSession().delete(ilan);
	}
	
	//READ 
	public ArrayList<ilanlar> getAll(){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM ilanlar");
		
		return (ArrayList<ilanlar>) query.getResultList();
	}

}
