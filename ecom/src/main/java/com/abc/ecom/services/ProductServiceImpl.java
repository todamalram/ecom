package com.abc.ecom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.CustomerNotFoundException;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		 
		Product savedProduct=productRepository.save(product);
		return savedProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list=productRepository.findAll();
		return list;
	}

	@Override
	public Product getProductById(int productId) {
		Optional<Product> product= productRepository.findById(productId) ;
		return product.get();
	}

	@Override
	public Product getProductByName(String productName) {
		Product product= productRepository.findByProductName(productName) ;
		return product;
	}

	@Override
	public List<Product> getProductByCategory(String Category) {
		 
		return productRepository.findProductByCategory(Category);
	}

	@Override
	public void deleteProduct(int customerId)  throws ProductNotFoundException
	{ 
			 Optional<Product> product=productRepository.findById(customerId);
			 if(product.isPresent()) {
				 productRepository.deleteById(customerId);
				 }
			 else 
			 {
				 throw new ProductNotFoundException("sorry customer is not existing with id:" +customerId);
			 }
	}
	@Override
	public Product updateProduct(Product product) throws ProductNotFoundException
	{
	   Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
		if(optionalProduct.isEmpty()) {
		throw new ProductNotFoundException("Sorry! customer not found with id" +product.getProductId());
		}
		Product updatedProduct=productRepository.save(product);
		return updatedProduct;
	}
		 
}
