package com.server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.Exceptions.CustomerException;
import com.server.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByEmail(String email)throws CustomerException;
	
	@Query(value = "SELECT * FROM customers WHERE ?1 LIKE %?2% ORDER BY ?3", nativeQuery = true)
    public List<Customer> findAllCustomers(String searchBy, String searchByVal,String sortBy) throws CustomerException;
	

}
