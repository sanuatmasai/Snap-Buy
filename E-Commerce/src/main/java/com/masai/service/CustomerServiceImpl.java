package com.masai.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.CustomerDao;
import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao custDao;

	@Override
	public Customer addCustomer(Customer cust) throws CustomerException {
		Customer add= custDao.save(cust);
		return add;
	}

	@Override
	public Customer updateCustomer(Customer cust) throws CustomerException {
		Customer customer = custDao.findById(cust.getUserId()).orElseThrow(() ->  new CustomerException("Invalid Customer Details Please Check"));
		return custDao.save(cust);
	}

	@Override
	public Customer removeCustomer(Integer customerId) throws CustomerException {

		Customer existingCustomer = custDao.findById(customerId).orElseThrow(() ->  new CustomerException("Customer Does not exist with the id :" + customerId));
		custDao.delete(existingCustomer);
		return existingCustomer;
	}

	@Override
	public Customer viewCustomer(Integer CustomerId) throws CustomerException {
		return custDao.findById(CustomerId).orElseThrow(() -> new CustomerException("No Customer Found with the Given ID:" +CustomerId));
	}

	@Override
	public List<Customer> viewAllCustomers() throws CustomerException {
		List<Customer> customerList= custDao.findAll();
		
		if(customerList.isEmpty()) throw new CustomerException("No Customer available");
		return customerList;
	}

}
