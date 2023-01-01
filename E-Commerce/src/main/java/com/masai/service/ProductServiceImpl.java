package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.ProductDao;
import com.masai.exceptions.ProductException;
import com.masai.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao pr;

	@Override
	public Product addProduct(Product product) {
		return pr.save(product);
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		Product product2 = pr.findById(product.getProductId()).orElseThrow(() -> new ProductException("Invalid Product Details Please Check"));
		return pr.save(product);
	}

	@Override
	public Product removeProduct(int productId) throws ProductException {
		Product product2 = pr.findById(productId).orElseThrow(() -> new ProductException("Invalid ProductID Please Check"));
		pr.deleteById(productId);
		
		return product2;
	}

	@Override
	public List<Product> viewAllProducts() throws ProductException{
		List<Product> list=pr.findAll();

		if(list.size()==0) throw new ProductException("No product available");
		return list;
	}

	@Override
	public Product viewProduct(int productId) throws ProductException{
		return pr.findById(productId).orElseThrow(() -> new ProductException("Invalid ProductID Please Check"));
		
	}

	@Override
	public List<Product> viewAllProductsByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

}
