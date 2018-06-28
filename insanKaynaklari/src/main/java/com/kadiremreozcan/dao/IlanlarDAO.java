package com.kadiremreozcan.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadiremreozcan.entity.Ilanlar;

@Repository
public class IlanlarDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	//CRUD iþlemleri yapýcaz
	
	//CREAT
	public Long insert(Ilanlar ilan) {
		//save ettiðinin id sini dönücek
		return (Long) sessionFactory.getCurrentSession().save(ilan);
	}
	
	//UPDATE id olmak zorunda
	public void update(Ilanlar ilan) {
		sessionFactory.getCurrentSession().update(ilan);
	}
	
	//PERSIST gönderdiðin deðere bakýyor varsa update ediyor yoksa create ediyor
	public void persist(Ilanlar ilan) {
		sessionFactory.getCurrentSession().persist(ilan);
	}
	
	//DELETE id olmak zorunda
	public void delete(Ilanlar ilan) {
		sessionFactory.getCurrentSession().delete(ilan);
	}
	
	//READ 
	public ArrayList<Ilanlar> getAll(){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Ilanlar");
		
		return (ArrayList<Ilanlar>) query.getResultList();
	}

}
