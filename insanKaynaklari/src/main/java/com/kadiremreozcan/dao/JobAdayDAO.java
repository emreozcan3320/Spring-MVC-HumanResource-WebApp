package com.kadiremreozcan.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadiremreozcan.entity.JobAday;


@Repository
public class JobAdayDAO {
	@Autowired
	private SessionFactory sessionFactory; 
	
	//CREAT
	public Long insert(JobAday basvuru) {
		return (Long) sessionFactory.getCurrentSession().save(basvuru);
	}
	
	//UPDATE
	public void update(JobAday basvuru) {
		sessionFactory.getCurrentSession().update(basvuru);
	}
	
	//DELETE id olmak zorunda
	public void delete(JobAday basvuru) {
		sessionFactory.getCurrentSession().delete(basvuru);
	}
	
	//READ bir ilanýn durumunu dönüyor
	
	
	//READ bir adayýn ilanlarýný döndürüyor
	@SuppressWarnings({ "deprecation", "unchecked" })
	public ArrayList<JobAday> getOneAdayApplications(Long aday_id){
	
	Query query = sessionFactory.getCurrentSession().createQuery("FROM JobAday WHERE aday_id=:aday_id ")
			.setLong("aday_id", aday_id);
	/*Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT id,activation_date,create_date,expertise,expiration_date,ik_uzmani_id,job_definition,personal_qualities,status,title FROM jobaday,jobs WHERE aday_id=:aday_id AND jobaday.job_id = jobs.id ")
			.setLong("aday_id", aday_id);*/
	
	return (ArrayList<JobAday>) query.getResultList();
	
	}
}
