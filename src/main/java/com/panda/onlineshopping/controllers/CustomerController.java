package com.panda.onlineshopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panda.onlineshopping.entities.Address;
import com.panda.onlineshopping.entities.Customer;
import com.panda.onlineshopping.entities.User;
import com.panda.onlineshopping.services.AddressService;
import com.panda.onlineshopping.services.CustomerService;
import com.panda.onlineshopping.services.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "edit/{customerId}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> editCustomer(@PathVariable("customerId") int customerId,
			@RequestBody Customer customer) {

		Customer currentCustomer = customerService.getCustomerById(customerId);
		if (currentCustomer == null)
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);

		currentCustomer = customer;
		currentCustomer.setUserid(customerId);
		customerService.updateCustomer(currentCustomer);
		return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
	}

	@RequestMapping(value = "get/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId) {

		Customer customer = customerService.getCustomerById(customerId);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	


}

