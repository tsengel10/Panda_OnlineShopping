package com.panda.onlineshopping.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panda.onlineshopping.entities.Cart;

@Controller
@RequestMapping("/cart")
public class CartController {

//	@Autowired
//	private CartService cartService;

	@RequestMapping(value = "test/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Cart>> getTest(@PathVariable int id) {
//		List<Cart> carts = cartService.getAll();
//		if (carts.isEmpty()) {
//		}
//		return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
		return new ResponseEntity<List<Cart>>(HttpStatus.NO_CONTENT);

		// List<User> admins = userService.getAllAdmins();
		// if (admins.isEmpty()) {
		// return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		// }
		// return new ResponseEntity<List<User>>(admins, HttpStatus.OK);
	}
}
