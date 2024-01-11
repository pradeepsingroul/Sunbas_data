package com.server.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.Exceptions.CustomerException;
import com.server.Model.Customer;
import com.server.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerServices{

	@Autowired
	private CustomerRepository cRepo;
	
	@Override
	public Customer createCustomer(Customer c) throws CustomerException {
		System.out.println(c);
		// TODO Auto-generated method stub
		try {
			System.out.println("I am 1");
			Optional<Customer> optional = cRepo.findById(c.getCustomerId());
			System.out.println("kkkkkkkk");
			if(!optional.isEmpty()) {
				System.out.println("I am 3");
				throw new CustomerException("Customer already exist with the id: "+c.getCustomerId());
			}else {
				System.out.println("I am 2");
				cRepo.save(c);
				return c;
			}
		} catch (Exception e) {
			System.out.println("I am 4");
			throw new CustomerException(e.getMessage());

		}
	}

	@Override
	public Customer getCustomerById(Integer id) throws CustomerException {
		try {
			Optional<Customer> optional = cRepo.findById(id);
			if(optional.isPresent()) {
				Customer customer = optional.get();
				 return customer;
			}else {
				throw new CustomerException("Customer does not exist with the id: "+id);
			}
		} catch (Exception e) {
			
			throw new CustomerException(e.getMessage());

		}
	}

	@Override
	public Customer deleteCustomerById(Integer id) throws CustomerException {
		try {
			Optional<Customer> optional = cRepo.findById(id);
			if(optional.isPresent()) {
				Customer customer = optional.get();
				cRepo.deleteById(id);
			    return customer;
			}else {
				throw new CustomerException("Customer does not exist with the id: "+id);
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());

		}
	}

	@Override
	public List<Customer> getAllCustomers(String searchBy,String searchByVal, String sortBy) throws CustomerException {
		try {
			List<Customer> list = cRepo.findAllCustomers(searchBy,searchByVal,sortBy);
			if(list.isEmpty()) {
				throw new CustomerException("Empty database.....");
			}else {
				return list;
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());

		}
	}

	@Override
	public Customer updateCustomerById(Customer c) throws CustomerException {
		try {
			Optional<Customer> optional = cRepo.findById(c.getCustomerId());
			if(optional.isPresent()) {
				 return cRepo.save(c);
			}else {
				throw new CustomerException("Customer does not exist with the id: "+c.getCustomerId());
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());

		}
	}

	@Override
	public Customer getCustomerByEmail(String email) throws CustomerException {
		try {
			Customer customer = cRepo.findByEmail(email);
			if(customer!=null) {
				 return customer;
			}else {
				throw new CustomerException("Customer does not exist with the email: "+email);
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());

		}
	}

}
