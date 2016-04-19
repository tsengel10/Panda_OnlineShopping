package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.Address;

public interface IAddressDao {

	public void createAddress(Address address);

	public Address updateAddress(Address address);

	public void deleteAddress(Address address);

	public List<Address> getAllAddresses();

	public Address getAddressByUserId(int userId);

	public Address getAddressById(int id);
}
