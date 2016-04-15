package com.panda.onlineshopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panda.onlineshopping.entities.Cart;
import com.panda.onlineshopping.entities.User;
import com.panda.onlineshopping.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "test/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getTest(@PathVariable int id) {
		List<Cart> carts = cartService.getAll();
		if (admin)
		
		
		
		
		
		List<User> admins = userService.getAllAdmins();
		if (admins.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(admins, HttpStatus.OK);
	}
}
