package com.server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.Exceptions.CustomerException;
import com.server.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Optional<Customer> findByEmail(String email)throws CustomerException;
	
	public Customer findByEmailAndPassword(String email, String password) throws CustomerException;
	
//	@Query(value = "SELECT * FROM customer WHERE ?1 LIKE %?2%", nativeQuery = true)
//    public List<Customer> findAllCustomers(String searchBy,String searchByVal) throws CustomerException;
	

}
