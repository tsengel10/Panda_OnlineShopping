package com.panda.onlineshopping.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panda.onlineshopping.entities.Cart;
import com.panda.onlineshopping.entities.CartItem;
import com.panda.onlineshopping.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	private int userIdSession = 2; // get it from session

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "get/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Cart> getCartItems(@PathVariable int userId) {
		Cart cart = cartService.getByUserId(userId);
		if (cart == null) {
			return new ResponseEntity<Cart>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		cartService.create(cart);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@RequestMapping(value = "delete/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Cart> deleteCart(@PathVariable int userId) {
		Cart cart = cartService.getByUserId(userId);
		cartService.delete(cart);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@RequestMapping(value = "addItem/{inventoryId}/{quantity}", method = RequestMethod.GET)
	public ResponseEntity<CartItem> addItems(@PathVariable int inventoryId, @PathVariable int quantity) {
		CartItem cartItem = cartService.addItem(userIdSession, inventoryId, quantity);
		return new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
	}
}
