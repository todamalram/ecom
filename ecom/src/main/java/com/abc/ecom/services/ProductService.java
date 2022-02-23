package com.abc.ecom.services;

import java.util.List;

import com.abc.ecom.entity.Product;



public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(int productId);
	public Product getProductByName(String productName);
	public List<Product> getProductByCategory(String Category);
	public void deleteProduct(int customerId);
	public Product updateProduct(Product product);
}
