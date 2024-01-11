package com.server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.Exceptions.CustomerException;
import com.server.Model.Customer;
import com.server.Services.CustomerServices;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerServices cService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException {
		System.out.println("Helllo");
		Customer c1 = cService.createCustomer(customer);
		return new ResponseEntity<Customer>(c1, HttpStatus.CREATED);
			
	}

	
	@GetMapping("/customers")
	public ResponseEntity<Customer> getCustomer(@RequestParam("id") Integer id) {
		
		Customer c1 = cService.getCustomerById(id);
		return new ResponseEntity<Customer>(c1, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<Customer> deleteCustomers(@RequestParam("id") Integer id) throws CustomerException {
		
		Customer c1 = cService.deleteCustomerById(id);
		return new ResponseEntity<Customer>(c1, HttpStatus.OK);
		
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) throws CustomerException {
		
		Customer c1 = cService.updateCustomerById(c);
		return new ResponseEntity<Customer>(c1, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomersPagi(@RequestParam("searchBy") String searchBy,@RequestParam("searchByVal") String searchByVal,@RequestParam("sortBy") String sortBy) throws CustomerException {
		
		List<Customer> c1 = cService.getAllCustomers(searchBy,searchByVal,sortBy);

		return new ResponseEntity<List<Customer>>(c1, HttpStatus.CREATED);
		
		
	}
}
