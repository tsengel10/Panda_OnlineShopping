package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.Customer;

public interface ICustomerService {

	public void createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(int customerId);
}
