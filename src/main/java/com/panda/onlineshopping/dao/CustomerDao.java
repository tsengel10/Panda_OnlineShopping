package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.Customer;
import com.panda.onlineshopping.utils.HibernateUtils;
import com.panda.onlineshopping.utils.PasswordUtils;

@Repository
public class CustomerDao implements ICustomerDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public void createCustomer(Customer customer) {
		customer.setPassword(PasswordUtils.hashPassword(customer.getPassword()));
		hibernateUtil.create(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return hibernateUtil.update(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		hibernateUtil.delete(customer);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return hibernateUtil.fetchAll(Customer.class);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return hibernateUtil.fetchById(customerId, Customer.class);
	}

}
