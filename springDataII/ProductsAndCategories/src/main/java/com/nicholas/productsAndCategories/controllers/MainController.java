package com.nicholas.productsAndCategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nicholas.productsAndCategories.services.CategoryService;
import com.nicholas.productsAndCategories.services.ProductService;

@Controller
public class MainController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
}


