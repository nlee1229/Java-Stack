package com.nicholas.studentRoster.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;



@Entity
@Table(name="contacts")
public class Contact {
 //------------CLASS MODELS AND VALIDATIONS-------------//
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Size(min=10, message="Address must contain more than 10 characters")
	 private String address;
	 
	 @Size(min=3, message="City must contain more than 3 characters")
	 private String city;
	 
	 @Size(max=2, message="State must contain 2 characters")
	 private String state;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 //------------------ONE TO ONE RELATIONSHIP---------------//
	 
	 @OneToOne(fetch = FetchType.LAZY)
	 
