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
import com.panda.onlineshopping.entities.User;
import com.panda.onlineshopping.services.AddressService;
import com.panda.onlineshopping.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<User> createVendor(@RequestBody User admin) {
		userService.createUser(admin);
		return new ResponseEntity<User>(admin, HttpStatus.OK);
	}

	@RequestMapping(value = "get/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		User user = userService.getUserById(userId);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "get/{adminId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getAdminById(@PathVariable int adminId) {
		User admin = userService.getAdminById(adminId);
		if (admin == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(admin, HttpStatus.OK);
	}

	@RequestMapping(value = "get/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllAdmins() {
		List<User> admins = userService.getAllAdmins();
		if (admins.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(admins, HttpStatus.OK);
	}

	@RequestMapping(value = "edit/{adminId}", method = RequestMethod.PUT)
	public ResponseEntity<User> editAdmin(@PathVariable("adminId") int adminId, @RequestBody User user) {

		User currentAdmin = userService.getAdminById(adminId);
		if (currentAdmin == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

		currentAdmin = user;
		currentAdmin.setUserid(adminId);
		userService.updateUser(currentAdmin);
		return new ResponseEntity<User>(currentAdmin, HttpStatus.OK);
	}

	// User Address related functions

	@RequestMapping(value = "get/addresses/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Address>> getAddressByUserId(@PathVariable int userId) {
		List<Address> addresses = addressService.getAddressesByUserId(userId);
		if (addresses.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
	}

	@RequestMapping(value = "create/address/{userId}", method = RequestMethod.POST)
	public ResponseEntity<Address> createAddress(@PathVariable("userId") int userId, @RequestBody Address address) {
		User user = userService.getUserById(userId);
		address.setUser(user);
		addressService.createAddress(address);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

}
