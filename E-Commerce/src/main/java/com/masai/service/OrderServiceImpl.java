package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.OrderDao;
import com.masai.exceptions.OrderException;
import com.masai.model.Orders;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao oRepo;

	@Override
	public Orders addOrder(Orders order) {
		return oRepo.save(order);
	}

	@Override
	public Orders updateOrders(Orders order) throws OrderException {
		Orders order1 = oRepo.findById(order.getOrderId()).orElseThrow(() -> new OrderException("Order not exist by this id "));
	
		return oRepo.save(order);
		
	}

	@Override
	public Orders removeOrders(Orders order) throws OrderException {
		
		Orders check1= oRepo.findById(order.getOrderId()).orElseThrow(()->new OrderException("order not exist with given id.."));
		oRepo.delete(check1);
		return order;
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {
		
		return  oRepo.findById(orderId).orElseThrow(() -> new OrderException("No order found"));
	}

	@Override
	public List<Orders> viewAllOrders() throws OrderException {
		
		List<Orders> allOrders= oRepo.findAll();
		if(allOrders.size()>0) {
			return allOrders;
		}else {
			throw new OrderException("order doesnot exist");
		}
	}

	@Override
	public List<Orders> viewAllOrdersByuserId(String userId) throws OrderException {
		
		List<Orders> list2 = oRepo.getOrdersByUserId(userId);
		
		if( list2.size() == 0) throw new OrderException("No order found with this userId.");
		return list2;
	}

}
