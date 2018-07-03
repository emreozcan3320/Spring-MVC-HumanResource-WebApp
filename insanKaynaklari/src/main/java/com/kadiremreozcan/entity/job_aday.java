package com.kadiremreozcan.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="applications")
public class job_aday {
	
	
	private Long ilan_id;
	private Long aday_id;
	
	private String hr_status;
	private String aday_status;

}
