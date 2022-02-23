package com.abc.ecom.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.CustomerNotFoundException;
import com.abc.ecom.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	@PostMapping("/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		Product newProduct=productService.saveProduct(product);
		ResponseEntity<Product> responseEntity=new ResponseEntity(newProduct,HttpStatus.CREATED);
		return responseEntity;
	}
	@GetMapping("/productlist")
	public List<Product> fetchAllProducts()
	{
	     List<Product> products=productService.getAllProducts();
	     return products;
	}
	@GetMapping("/get/{pid}")
	public ResponseEntity<?> fetchProductDetails(@PathVariable ("pid") int productId)
	{
		ResponseEntity<?> responseEntity=null;
		Product product= productService.getProductById(productId);
		if(product!=null)
			  responseEntity=new ResponseEntity<>(product,HttpStatus.OK);
		else
			responseEntity=new ResponseEntity<>("ProductNotAvailable with Id:-"+productId,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@GetMapping("/getbyname/{pname}")
	public ResponseEntity<?> fetchProductDetailsByName(@PathVariable ("pname") String productName)
	{
		ResponseEntity<?> responseEntity=null;
		Product product= productService.getProductByName(productName);
		if(product!=null)
			  responseEntity=new ResponseEntity<>(product,HttpStatus.OK);
		else
			responseEntity=new ResponseEntity<>("ProductNotAvailable with Name:-"+productName,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@GetMapping("/getbycategory/{pcategory}")
	public ResponseEntity<?> fetchProductDetailsByCategory(@PathVariable ("pcategory") String productCategory)
	{
		ResponseEntity<?> responseEntity=null;
		List<Product> product=productService.getProductByCategory(productCategory);
		if(product!=null)
			  responseEntity=new ResponseEntity<>(product,HttpStatus.OK);
		else
			responseEntity=new ResponseEntity<>("ProductNotAvailable with Name:-"+productCategory,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("pid") int customerId) throws CustomerNotFoundException {

	productService.deleteProduct(customerId);
	return new ResponseEntity<>("Customer Deleted with id:" + customerId, HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody Product product)  {
		Product newProduct=productService.saveProduct(product);
		ResponseEntity<Product> responseEntity=new ResponseEntity(newProduct,HttpStatus.CREATED);
		return responseEntity;
	}
}
