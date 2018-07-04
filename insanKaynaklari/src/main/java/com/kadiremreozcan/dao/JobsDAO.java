package com.kadiremreozcan.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadiremreozcan.entity.Jobs;

@Repository
public class JobsDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	//CRUD iþlemleri yapýcaz
	
	//CREAT
	public Long insert(Jobs ilan) {
		//save ettiðinin id sini dönücek
		return (Long) sessionFactory.getCurrentSession().save(ilan);
	}
	
	//UPDATE id olmak zorunda
	public void update(Jobs ilan) {
		sessionFactory.getCurrentSession().update(ilan);
	}
	
	//PERSIST gönderdiðin deðere bakýyor varsa update ediyor yoksa create ediyor
	public void persist(Jobs ilan) {
		sessionFactory.getCurrentSession().persist(ilan);
	}
	
	//DELETE id olmak zorunda
	public void delete(Jobs ilan) {
		sessionFactory.getCurrentSession().delete(ilan);
	}
	
	//READS
	
	
	//READ ALL JOBS
	@SuppressWarnings("deprecation")
	public Jobs getFindById(Long job_id){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Jobs  WHERE id=:job_id")
				.setLong("job_id", job_id);
			
		return (Jobs) query.getSingleResult();
	}	
	
	//READ ALL JOBS
	@SuppressWarnings("unchecked")
	public ArrayList<Jobs> getAll(){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Jobs");
		
		return (ArrayList<Jobs>) query.getResultList();
	}
	
	//READ ALL JOBS OF ONE ISVEREN
	@SuppressWarnings({ "unchecked", "deprecation" })
	public ArrayList<Jobs> getAll(Long uzman_id){
		//"FROM Jobs WHERE user_id="+user_id kullanýmýda olur ama güvenlik açýðýna sebebiyet verebilir 
		//bundan dolayý hibernate in önerdiði yolu kullanýyoruz.
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Jobs WHERE ik_uzmani_id=:uzman_id order by id DESC")
				.setLong("uzman_id", uzman_id);
		
		return (ArrayList<Jobs>) query.getResultList();
	}
	

}
