package com.masai.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Size(min = 3, max = 10, message = "Street no. should min of 3 and max of 10 Characters")
	private String streetNo;
	private String buildingName;
	
	@NotBlank(message = "City should not be blank.")
	private String city;
	
	@NotBlank(message = "State cannot be blank.")
	private String state;
	
	@NotBlank(message = "Country cannot be blank.")
	private String country;
	
	@NotBlank(message = "Pincode cannot be blank.")
	private String pincode;
		
}
