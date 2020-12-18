package com.nicholas.dojosAndNinjas3.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {

	//--------Model attributes--------//
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	@Size(min=2, message="Location must be more than 2 characters.")
	private String location;
	
	@Size(min=5, message="Review must be more than 5 characters.")
	private String review;
	
	@Past(message="Review must be from the past.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Range(min=1, max=5, message="Please choose a rating.")
	private Integer rating;

	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="ninja_id")
	private Ninja ninja;
	
	public Dojo() {
		
	}
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getReview() {
		return review;
	}



	public void setReview(String review) {
		this.review = review;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Integer getRating() {
		return rating;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Ninja getNinja() {
		return ninja;
	}



	public void setNinja(Ninja ninja) {
		this.ninja = ninja;
	}



	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}	
	
	
}