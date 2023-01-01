package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends User {
	
	@Size(min = 3, max = 15, message = "The first name should be min 3 and max of 15 characters.")
	private String firstName;
	
	@Size(min = 1, max = 15, message = "The last name should be min 1 and max of 15 characters.")
	private String lastName;
	
	@Size(min = 10, max = 10, message = "Mobile Number should contain 10 digit only")
	private String mobileNumber;
	
	@Email(message = "Please enter valid email address")
	private String email;
	
	@JsonIgnore
	@ElementCollection
	@Embedded
	@JoinTable(name="customer_Address", joinColumns=@JoinColumn(name="customer_id"))
	private List<Address> addresses = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	@JoinColumn(name="cart_FK")
	private Cart cart;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	List<Orders> order_list = new ArrayList<>();
}
