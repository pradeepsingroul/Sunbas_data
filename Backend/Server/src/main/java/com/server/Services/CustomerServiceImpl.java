package com.server.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		// TODO Auto-generated method stub
		try {
			System.out.println(c);
			Optional<Customer> optional = cRepo.findByEmail(c.getEmail());
			if(optional.isEmpty()) {
				System.out.println("dfgsdfgdsfgsdgsdfg");
				Customer c1 = cRepo.save(c);
				return c1;
			}else {
				throw new CustomerException("Customer already exist with the email: "+c.getEmail());
			}
		} catch (Exception e) {
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
	public Page<Customer> getAllCustomers(Integer offSet, Integer pageSize) throws CustomerException {
		try {
			Page<Customer> pages = cRepo.findAll(PageRequest.of(offSet, pageSize));
//			List<Customer> list = cRepo.findAll(Sort.by(sortBy));
//			System.out.println(list);
			if(pages.isEmpty()) {
				throw new CustomerException("Empty database.....");
			}else {
				return pages;
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
			Optional<Customer> optional = cRepo.findByEmail(email);
			if(!optional.isEmpty()) {
				Customer c = optional.get();
				 return c;
			}else {
				throw new CustomerException("Customer does not exist with the email: "+email);
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());

		}
	}

	@Override
	public List<Customer> getAll() throws CustomerException {
		return cRepo.findAll();
	}

	@Override
	public Customer loginCustomer(String email, String password) throws CustomerException {
		try {
			Customer logedinC = cRepo.findByEmailAndPassword(email, password);
			if(logedinC!=null) {
				return logedinC;
			}else {
				throw new CustomerException("You have entered something wronog creadentiakl......");
			}
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
			// TODO: handle exception
		}
		
	}

}
