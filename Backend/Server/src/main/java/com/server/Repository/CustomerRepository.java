package com.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
}
