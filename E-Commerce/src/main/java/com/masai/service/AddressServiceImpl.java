package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.AddressDao;
import com.masai.exceptions.AddressException;
import com.masai.model.Address;

@Service
public class AddressServiceImpl implements AddressService {
	
//	@Autowired
//	private AddressDao aDao;
	
	
	@Override
	public Address addAddress(Address address) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(Address address) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address deleteAddressId(Integer addressId) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAllAddress() throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address viewAddressById(Integer addressId) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

}
