package com.server.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Customer {
	
	@Id
	private String first_name;
	
	private String last_name;
	
	private String street;
	
	private String address;
	
	private String city;
	
	private String state;
	
	@Email
	private String email;
	
	@Size(max = 10, min = 10)
	private String phone;
	 
	 
	
	

}
