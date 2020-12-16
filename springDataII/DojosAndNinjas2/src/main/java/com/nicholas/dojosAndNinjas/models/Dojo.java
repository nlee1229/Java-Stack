package com.nicholas.dojosAndNinjas.models;

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
import javax.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class Dojo {
	
	//----------Model Attributes----------//
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Size(min=1, max=50, message="Name must be between 1 and 50 characters!")
	 private String name;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	 private List<Ninja> ninjas;
	 
	 //---------Constructor--------//
	 
	 public Dojo() {
	     
	 }
	
	public Dojo(@Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters!") String name,
			List<Ninja> ninjas) {
		super();
		this.name = name;
		this.ninjas = ninjas;
	}
	
	//------------Getters and setters-----------//
	
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
	
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
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
