package com.server.Services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.server.Exceptions.CustomerException;
import com.server.Model.Customer;

public interface CustomerServices {
	
	public Customer createCustomer(Customer c) throws CustomerException;
	
	public Customer getCustomerById(Integer id) throws CustomerException;
	
	public List<Customer> getAll() throws CustomerException;

	
	public Customer deleteCustomerById(Integer id) throws CustomerException;
	
	public Page<Customer> getAllCustomers(Integer offSet, Integer pageSize) throws CustomerException;
	
	public Customer updateCustomerById(Customer c) throws CustomerException;
	
	public Customer getCustomerByEmail(String email) throws CustomerException;
}
