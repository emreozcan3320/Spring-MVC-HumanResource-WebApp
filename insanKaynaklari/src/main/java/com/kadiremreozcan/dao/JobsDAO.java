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
	
	//CRUD i�lemleri yap�caz
	
	//CREAT
	public Long insert(Jobs ilan) {
		//save etti�inin id sini d�n�cek
		return (Long) sessionFactory.getCurrentSession().save(ilan);
	}
	
	//UPDATE id olmak zorunda
	public void update(Jobs ilan) {
		sessionFactory.getCurrentSession().update(ilan);
	}
	
	//PERSIST g�nderdi�in de�ere bak�yor varsa update ediyor yoksa create ediyor
	public void persist(Jobs ilan) {
		sessionFactory.getCurrentSession().persist(ilan);
	}
	
	//DELETE id olmak zorunda
	public void delete(Jobs ilan) {
		sessionFactory.getCurrentSession().delete(ilan);
	}
	
	//READS
	
	
	//READ ALL JOBS
	public Jobs getFindById(Long job_id){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Jobs  WHERE id=:job_id")
				.setLong("job_id", job_id);
			
		return (Jobs) query.getSingleResult();
	}	
	
	//READ ALL JOBS
	public ArrayList<Jobs> getAll(){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Jobs");
		
		return (ArrayList<Jobs>) query.getResultList();
	}
	
	//READ ALL JOBS OF ONE ISVEREN
	public ArrayList<Jobs> getAll(Long uzman_id){
		//"FROM Jobs WHERE user_id="+user_id kullan�m�da olur ama g�venlik a����na sebebiyet verebilir 
		//bundan dolay� hibernate in �nerdi�i yolu kullan�yoruz.
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Jobs WHERE ik_uzmani_id=:uzman_id order by id DESC")
				.setLong("uzman_id", uzman_id);
		
		return (ArrayList<Jobs>) query.getResultList();
	}
	

}
