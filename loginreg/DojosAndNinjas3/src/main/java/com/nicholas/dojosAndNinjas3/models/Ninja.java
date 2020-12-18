package com.nicholas.dojosAndNinjas3.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="ninjas")
public class Ninja {
	
	//---------Model attributes-----------//
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Size(min=2, message="First name must be at least 2 characters.")
	 private String firstName;
	 
	 @Size(min=2, message="Last name must be at least 2 characters.")
	 private String lastName;
	 
	 @Email(message="Must be a valid email.")
	 @Size(min=5, message="Email name must be at least 5 characters.")
	 private String email;
	 
	 @Size(min=5, message="Password must be at least 5 characters.")
	 private String password;
	 
	 @Transient
	 private String passwordConfirmation;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 //-------Relationship(one ninja visiting many dojos-------//
	 @OneToMany(mappedBy="ninja", fetch = FetchType.LAZY)
	 private List<Dojo> dojos;
	 
	 //------Contructor-------//
	 
	 public Ninja() {
		 
	 }
	 
	 
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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



	public List<Dojo> getDojos() {
		return dojos;
	}



	public void setDojos(List<Dojo> dojos) {
		this.dojos = dojos;
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
