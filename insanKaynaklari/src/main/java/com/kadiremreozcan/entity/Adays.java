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
@Table(name="adays")
public class Adays {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private String name;
	private String surname;
	private String email;
	
	private String interests;
	private String publications;
	private String patents;
	private String languages;
	private String skills;
	private String certifications;
	private String educations;
	private String courses;
	private String volunteer;
	private String dateOfBirth;
	

	private Date create_date = new Date();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getInterests() {
		return interests;
	}


	public void setInterests(String interests) {
		this.interests = interests;
	}


	public String getPublications() {
		return publications;
	}


	public void setPublications(String publications) {
		this.publications = publications;
	}


	public String getPatents() {
		return patents;
	}


	public void setPatents(String patents) {
		this.patents = patents;
	}


	public String getLanguages() {
		return languages;
	}


	public void setLanguages(String languages) {
		this.languages = languages;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public String getCertifications() {
		return certifications;
	}


	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}


	public String getEducations() {
		return educations;
	}


	public void setEducations(String educations) {
		this.educations = educations;
	}


	public String getCourses() {
		return courses;
	}


	public void setCourses(String courses) {
		this.courses = courses;
	}


	public String getVolunteer() {
		return volunteer;
	}


	public void setVolunteer(String volunteer) {
		this.volunteer = volunteer;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Date getCreate_date() {
		return create_date;
	}


	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}


	@Override
	public String toString() {
		return "Adays [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", interests="
				+ interests + ", publications=" + publications + ", patents=" + patents + ", languages=" + languages
				+ ", skills=" + skills + ", certifications=" + certifications + ", educations=" + educations
				+ ", courses=" + courses + ", volunteer=" + volunteer + ", dateOfBirth=" + dateOfBirth
				+ ", create_date=" + create_date + "]";
	}


 
	
	
	
	 
	
	

}
