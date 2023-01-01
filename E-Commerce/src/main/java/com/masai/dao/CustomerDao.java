package com.masai.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	public Customer findByMobileNumber(String mobileNo);
	
//	@Query("select c from Customer c where c.address.city=?1")
//	public List<Customer> getCustomerByCity(String location) throws CustomerException;
}
