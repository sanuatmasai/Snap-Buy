package com.masai.service;

import java.util.List;

import com.masai.exceptions.ProductException;
import com.masai.model.Product;

public interface ProductService {
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product) throws ProductException;
	
	public Product removeProduct(int productId) throws ProductException;
	
	public List<Product> viewAllProducts() throws ProductException;
	
	public Product viewProduct(int productId) throws ProductException;

	public List<Product> viewAllProductsByCategory(String categoryName);
}
