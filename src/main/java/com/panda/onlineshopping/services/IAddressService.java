package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.Address;

public interface IAddressService {

	public List<Address> getAddressesByUserId(int userId);

	public void createAddress(Address address);

	public void deleteAddressesByUserId(int userId);

	public Address getAddressById(int id);

	public Address updateAddress(Address address);

}
