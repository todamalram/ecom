package com.abc.ecom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.exception.CustomerNotFoundException;
import com.abc.ecom.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public Customer saveCustomer(Customer customer) {
		Customer  saveCustomer=customerRepository.save(customer);
		return saveCustomer;
	}
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=customerRepository.findAll();
		return list;
	}
	@Override
	public Customer getCustomerById(int customerId) {
		 java.util.Optional<Customer> customer=customerRepository.findById(customerId);
		return customer.get();
	}

	@Override
	public void deleteCustomer(int customerId) throws CustomerNotFoundException {
		 java.util.Optional<Customer> customer=customerRepository.findById(customerId);
		 if(customer.isPresent()) {
			 customerRepository.deleteById(customerId);
			 }
		 else 
		 {
			 throw new CustomerNotFoundException("sorry customer is not existing with id:" +customerId);
		 }
	}
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException
	{
	   java.util.Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isEmpty()) {
		throw new CustomerNotFoundException("Sorry! customer not found with id" +customer.getCustomerId());
		}
		Customer updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;
	}

	 
	
}
