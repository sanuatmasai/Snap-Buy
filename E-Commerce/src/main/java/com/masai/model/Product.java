
package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Size(min = 3, message = "The product name should contain min 3 characters." )
	private String productName;
	
	@Min(value=1, message = "Please enter a valid value as a price.")
	private double price;
	
	private String color;
	
	private String dimension;
	
	private String specification;
	
	private String manufacturer;
	
	@Min(value=1, message = "Please enter a valid quantity.")
	private int quantity;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;	
}
