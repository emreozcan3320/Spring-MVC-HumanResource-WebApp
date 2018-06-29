package com.kadiremreozcan.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadiremreozcan.entity.Jobs;

@Repository
public class HrStaffsDAO {
	@Autowired
	private SessionFactory sessionFactory; 
		
	//CRUD iþlemleri yapýcaz
		public ArrayList<Jobs> getAll(Long uzman_id){
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Jobs WHERE id=:uzman_id")
					.setLong("uzman_id", uzman_id);
			
			return (ArrayList<Jobs>) query.getResultList();
		}

}
