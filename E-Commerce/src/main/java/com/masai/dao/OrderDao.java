package com.masai.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Orders;

@Repository
public interface OrderDao extends JpaRepository<Orders, Integer> {
	
	@Query("select o from Orders o where o.customer.mobileNumber=?1")
	public List<Orders> getOrdersByUserId(String userID);
}
