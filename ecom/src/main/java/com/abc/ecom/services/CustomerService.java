package com.abc.ecom.services;

import java.util.List;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.exception.CustomerNotFoundException;

public interface CustomerService {
	public Customer saveCustomer(Customer customer);
	
	public List<Customer> getAllCustomers();
 
	public Customer getCustomerById(int customerId);
 
	public void deleteCustomer(int customerId) throws CustomerNotFoundException;

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
}
