package com.nicholas.dojosAndNinjas.models;

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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="ninjas")
public class Ninja {
	
	//----------Model Attributes----------//
	//---------- Ninja is the child of Dojo-----------//
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Size(min=2, message="First name must be more than 2 characters!")
	 private String firstName;
	 
	 @Size(min=2, message="Last Name must be more than 2 characters!")
	 private String lastName;
	 
	 @Range(min=3, max=99l, message="Age should not be less than 3 or greater than 99")
	 private int age;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 //----------you can instantiate a dojo object with a ninja. "dojo" is one whole object----------//
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="dojo_id")
	 private Dojo dojo;
	 
	 //-----------------Constructor----------------//
	 
	 public Ninja() {
	     
	 }
	
	public Ninja(@Size(min = 2, message = "First name must be more than 2 characters!") String firstName,
			@Size(min = 2, message = "Last Name must be more than 2 characters!") String lastName,
			@Range(min = 3, max = 99, message = "Age should not be less than 3 or greater than 99") int age, Dojo dojo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dojo = dojo;
	}
	
	//--------Getters and setters-----------//
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
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
	
	public Dojo getDojo() {
		return dojo;
	}
	
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
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
