package com.panda.onlineshopping.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panda.onlineshopping.entities.Cart;
import com.panda.onlineshopping.entities.CartItem;
import com.panda.onlineshopping.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "items/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Cart> getCartItems(@PathVariable int userId) {
		Cart cart = cartService.getByUserId(userId);
		if (cart == null) {
			return new ResponseEntity<Cart>(HttpStatus.NO_CONTENT);
		}
//		Set<CartItem> items = cart.getCartItems();
//		if (items.isEmpty()) {
//			return new ResponseEntity<Cart>(HttpStatus.NO_CONTENT);
//		}
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
}
