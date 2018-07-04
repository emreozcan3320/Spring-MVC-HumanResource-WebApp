package com.kadiremreozcan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JobAday {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "aday_id")
    private Adays adays;

	@ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;
	
	private String hr_status;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Adays getAdays() {
		return adays;
	}

	public void setAdays(Adays adays) {
		this.adays = adays;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public String getHr_status() {
		return hr_status;
	}

	public void setHr_status(String hr_status) {
		this.hr_status = hr_status;
	}

	public String getAday_status() {
		return aday_status;
	}

	public void setAday_status(String aday_status) {
		this.aday_status = aday_status;
	}

	@Override
	public String toString() {
		return "JobAday [id=" + id + ", adays=" + adays + ", jobs=" + jobs + ", hr_status=" + hr_status
				+ ", aday_status=" + aday_status + "]";
	}
	
	
	
	
}
