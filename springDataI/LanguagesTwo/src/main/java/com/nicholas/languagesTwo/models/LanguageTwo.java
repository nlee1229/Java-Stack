package com.nicholas.languagesTwo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languagesTwo")
public class LanguageTwo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 20, message="Name must be between 2 and 20 characters long")
	private String name;
	
	@Size(min = 2, max = 20, message="Creator must be between 2 and 20 characters long")
	private String creator;
	
	@Size(min = 1, max = 20, message="Version must be between 2 and 20 characters long")
	private String currentVersion;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    // ----------------------------------------------------------//
    //----------Language constructor-------------//
    
   
	public LanguageTwo() {
			
		}
	public LanguageTwo(Long id,
			@Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters long") String name,
			@Size(min = 2, max = 20, message = "Creator must be between 2 and 20 characters long") String creator,
			@Size(min = 1, max = 20, message = "Version must be between 2 and 20 characters long") String currentVersion,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	//---------Getters and setters-----------//
	
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
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCurrentVersion() {
		return currentVersion;
	}
	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
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
	
	 @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	
	
	
    
    
    
    
    
    
    
    
}