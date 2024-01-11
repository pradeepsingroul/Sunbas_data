package com.server.Services;

import java.util.List;

import com.server.Exceptions.CustomerException;
import com.server.Model.Customer;

public interface CustomerServices {
	
	public Customer createCustomer(Customer c) throws CustomerException;
	
	public Customer getCustomerById(Integer id) throws CustomerException;
	
	public Customer deleteCustomerById(Integer id) throws CustomerException;
	
	public List<Customer> getAllCustomers(String searchBy,String searchByVal, String sortBy) throws CustomerException;
	
	public Customer updateCustomerById(Customer c) throws CustomerException;
	
	public Customer getCustomerByEmail(String email) throws CustomerException;
}
