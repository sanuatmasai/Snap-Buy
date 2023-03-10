package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.OrderException;
import com.masai.model.Orders;
import com.masai.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService oService;
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> addOrderHandler(@Valid @RequestBody Orders order){
		Orders saveOrder= oService.addOrder(order);
		return new ResponseEntity<Orders>(saveOrder,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/orders")
	public ResponseEntity<Orders> updateOrderHandler(@RequestBody Orders order) throws OrderException{
		Orders updateOrders= oService.updateOrders(order);
		return new ResponseEntity<Orders>(updateOrders,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/orders")
	public ResponseEntity<Orders> removeOrdersHandler(@RequestBody Orders order) throws OrderException{
		Orders removeOrder= oService.removeOrders(order);
		return new ResponseEntity<Orders>(removeOrder, HttpStatus.OK);
		
	}
	@GetMapping("/orders/{orderid}")
	public ResponseEntity<Orders> veiwOrderHandler(@PathVariable("orderid") Integer id) throws OrderException{
		Orders getOrders= oService.viewOrder(id);
		return new ResponseEntity<Orders>(getOrders, HttpStatus.OK);
		
	}
	
	@GetMapping("/allOrders")
	public ResponseEntity<List<Orders>> getAllOrderHandler() throws OrderException{
		List<Orders> ordersList= oService.viewAllOrders();
		return new ResponseEntity<List<Orders>>(ordersList, HttpStatus.OK);
		
	}
	
	@GetMapping("/allorders/{userId}")
    public ResponseEntity<List<Orders>> getAllOrdersByUserIdHandler(@PathVariable("UserId") String userId) throws OrderException{
    	
    	List<Orders> ordersList3 = oService.viewAllOrdersByuserId(userId);
    	
    	return new ResponseEntity<List<Orders>>(ordersList3, HttpStatus.OK);
    	
    }
}
