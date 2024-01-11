package com.server.Services;

import java.util.List;

import com.server.Exceptions.CustomerException;
import com.server.Model.Customer;

public interface CustomerServices {
	
	public Customer createCustomer(Customer c) throws CustomerException;
	
	public Customer getCustomerById(Integer id) throws CustomerException;
	
	public Customer deleteCustomerById(Integer id) throws CustomerException;
	
	public List<Customer> getAllCustomers() throws CustomerException;
	
	public Customer updateCustomerById(Integer id) throws CustomerException;
	
}
