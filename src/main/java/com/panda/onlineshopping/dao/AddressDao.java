package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.Address;
import com.panda.onlineshopping.utils.HibernateUtils;

@Repository
public class AddressDao implements IAddressDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public void createAddress(Address address) {
		hibernateUtil.create(address);
	}

	@Override
	public Address updateAddress(Address address) {
		return hibernateUtil.update(address);
	}

	@Override
	public void deleteAddress(Address address) {
		hibernateUtil.delete(address);
	}

	@Override
	public List<Address> getAllAddresses() {
		return hibernateUtil.fetchAll(Address.class);
	}

	@Override
	public Address getAddressByUserId(int userId) {
		return hibernateUtil.fetchById(userId, Address.class);
	}

	@Override
	public Address getAddressById(int id) {
		String query = "from Address where id = '" + id + "'";
		Address dbAddress = (Address) hibernateUtil.runSelectQuery(query);
		if (dbAddress != null)
			return dbAddress;
		return null;
	}

}
