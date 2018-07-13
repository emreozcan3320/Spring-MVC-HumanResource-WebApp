package com.kadiremreozcan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlackList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

    private Long aday_id;

    private Long hr_id;
	
	@Column(length=9999)
	private String reason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAday_id() {
		return aday_id;
	}

	public void setAday_id(Long aday_id) {
		this.aday_id = aday_id;
	}

	public Long getHr_id() {
		return hr_id;
	}

	public void setHr_id(Long hr_id) {
		this.hr_id = hr_id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "BlackList [id=" + id + ", aday_id=" + aday_id + ", hr_id=" + hr_id + ", reason=" + reason + "]";
	}
	
	
	

}
