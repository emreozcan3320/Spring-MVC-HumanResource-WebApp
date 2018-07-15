package com.kadiremreozcan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobAday {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "jobaday_id", updatable = false, nullable = false)
	private Long jobaday_id;

    private Long aday_id;

    private Long job_id;
	
	private String basvuru_statusu;

	

	public Long getJobaday_id() {
		return jobaday_id;
	}

	public void setJobaday_id(Long jobaday_id) {
		this.jobaday_id = jobaday_id;
	}

	public Long getAday_id() {
		return aday_id;
	}

	public void setAday_id(Long aday_id) {
		this.aday_id = aday_id;
	}

	public Long getJob_id() {
		return job_id;
	}

	public void setJob_id(Long job_id) {
		this.job_id = job_id;
	}

	public String getBasvuru_statusu() {
		return basvuru_statusu;
	}

	public void setBasvuru_statusu(String basvuru_statusu) {
		this.basvuru_statusu = basvuru_statusu;
	}

	@Override
	public String toString() {
		return "JobAday [jobaday_id=" + jobaday_id + ", aday_id=" + aday_id + ", job_id=" + job_id
				+ ", basvuru_statusu=" + basvuru_statusu + "]";
	}

	

	

		
	
}
