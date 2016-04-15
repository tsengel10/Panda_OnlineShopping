package com.panda.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.onlineshopping.dao.AddressDao;
import com.panda.onlineshopping.dao.UserDao;
import com.panda.onlineshopping.entities.Address;

@Service
public class AddressService implements IAddressService {

	@Autowired
	private UserDao adminDao;
	@Autowired
	private AddressDao addressDao;

	@Override
	public void createAddress(Address address) {
		addressDao.createAddress(address);
	}

	@Override
	public List<Address> getAddressesByUserId(int userId) {
		List<Address> addresses = new ArrayList<>();
		for (Address address : adminDao.getAllAddresses()) {
			if (address.getUser().getUserid() == userId)
				addresses.add(address);
		}
		return addresses;
	}

	@Override
	public void deleteAddressesByUserId(int userId) {
		List<Address> addresses = this.getAddressesByUserId(userId);
		for (Address address : addresses) {
			addressDao.deleteAddress(address);
		}
	}

}
