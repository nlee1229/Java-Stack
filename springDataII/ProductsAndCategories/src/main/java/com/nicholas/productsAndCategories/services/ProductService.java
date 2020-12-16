package com.nicholas.productsAndCategories.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicholas.productsAndCategories.repos.ProductRepo;

@Service
public class ProductService {

	@Autowired 
	private ProductRepo productRepo;
}
