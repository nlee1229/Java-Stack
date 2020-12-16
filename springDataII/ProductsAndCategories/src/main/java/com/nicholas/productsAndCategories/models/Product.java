package com.nicholas.productsAndCategories.models;

import java.util.Date;
import java.util.List;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

	@Entity
	@Table(name="products")
	public class Product {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Size(min=1, message="Name must be at least 1 character!")
	    private String name;
	    
	    @Size(min=10, message="Description must be at least 10 characters!")
	    private String description;
	    
	    @Min(10)
	    @Max(250)
	    private int price;
	    
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "categories_products", 
	        joinColumns = @JoinColumn(name = "product_id"), 
	        inverseJoinColumns = @JoinColumn(name = "category_id")
	    )
	    private List<Category> categories;
	    
	    public Product() {
	        
	    }
	    
	    
	    public Product(Long id, @Size(min = 1, message = "Name must be at least 1 character!") String name,
				@Size(min = 10, message = "Description must be at least 10 characters!") String description,
				@Min(10) @Max(250) int price, Date createdAt, Date updatedAt, List<Category> categories) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.categories = categories;
		}

	    //--------------Getters and setters--------------------//
	 
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


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public int getPrice() {
			return price;
		}


		public void setPrice(int price) {
			this.price = price;
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


		public List<Category> getCategories() {
			return categories;
		}


		public void setCategories(List<Category> categories) {
			this.categories = categories;
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
