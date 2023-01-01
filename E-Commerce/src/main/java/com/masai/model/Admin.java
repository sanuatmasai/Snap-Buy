package com.masai.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User {
	@Size(min = 3, max = 15, message = "The first name should be min 3 and max of 15 characters.")
	private String firstname;
	
	@Size(min = 1, max = 15, message = "The last name should be min 1 and max of 15 characters.")
	private String lastname;
	
	@Size(min = 10, max = 10, message = "Mobile Number should contain 10 digit only")
	private String mobileNumber;
	
	@Email(message = "Please enter valid email address")
	private String email;
}
