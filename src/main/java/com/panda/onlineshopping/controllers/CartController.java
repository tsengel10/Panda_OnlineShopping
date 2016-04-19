package com.panda.onlineshopping.controllers;

import org.json.simple.JSONObject;
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

	private int userIdSession = 2; // get it from session
	private int quantityLimit = 100; // should get it from properties file

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

	@RequestMapping(value = "create/{userId}", method = RequestMethod.POST)
	public ResponseEntity<Cart> createCart(@PathVariable int userId) {
		Cart currentCart = cartService.getByUserId(userId);
		if (currentCart != null) {
			return new ResponseEntity<Cart>(currentCart, HttpStatus.OK);
		}
		Cart cart = new Cart();
		cart.setQuantityLimit(quantityLimit);
		cart.setUserId(userId);
		cartService.create(cart);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "delete/{userId}", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> deleteCart(@PathVariable int userId) {
		JSONObject ob = new JSONObject();
		Cart cart = cartService.getByUserId(userId);
		if (cart != null) {
			ob.put("status", "success");
			cartService.delete(cart);
		} else {
			ob.put("status", "fail");
			ob.put("message", "Cart does not exist");
		}
		return new ResponseEntity<JSONObject>(ob, HttpStatus.OK);
	}

	@RequestMapping(value = "addItem/{userIdSession}/{inventoryId}/{quantity}", method = RequestMethod.GET)
	public ResponseEntity<CartItem> addItems(@PathVariable int userIdSession, @PathVariable int inventoryId,
			@PathVariable int quantity) {
		CartItem cartItem = cartService.addItem(userIdSession, inventoryId, quantity);
		return new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
	}
}
