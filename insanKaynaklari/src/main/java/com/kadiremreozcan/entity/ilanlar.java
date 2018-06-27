package com.kadiremreozcan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="ilanlar")
public class ilanlar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private Long ik_uzmani_id;
	
	private boolean status = true;
	
	private Date create_date = new Date();
	private Date activation_date;
	private Date expiration_date;
	
	@Column(length=9999)
	private String title;
	@Column(length=9999)
	private String job_definition;
	
	 @Lob
	 @Column(name = "personal_qualities")
	 private String personal_qualities;
	 
	 @Lob
	 @Column(name = "expertise")
	 private String expertise;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIk_uzmani_id() {
		return ik_uzmani_id;
	}

	public void setIk_uzmani_id(Long ik_uzmani_id) {
		this.ik_uzmani_id = ik_uzmani_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getActivation_date() {
		return activation_date;
	}

	public void setActivation_date(Date activation_date) {
		this.activation_date = activation_date;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJob_definition() {
		return job_definition;
	}

	public void setJob_definition(String job_definition) {
		this.job_definition = job_definition;
	}

	public String getPersonal_qualities() {
		return personal_qualities;
	}

	public void setPersonal_qualities(String personal_qualities) {
		this.personal_qualities = personal_qualities;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	 
	 
	

}
