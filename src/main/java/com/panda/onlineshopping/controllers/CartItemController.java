package com.panda.onlineshopping.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panda.onlineshopping.entities.CartItem;
import com.panda.onlineshopping.services.CartItemService;

@Controller
@RequestMapping("/cartItem")
public class CartItemController {

	private int userIdSession = 2; // get it from session

	@Autowired
	private CartItemService cartItemService;

	@RequestMapping(value = "updateQuantity/{cartItemId}/{quantity}", method = RequestMethod.GET)
	public ResponseEntity<CartItem> update(@PathVariable int cartItemId, @PathVariable int quantity) {
		CartItem status = cartItemService.updateQuantity(cartItemId, quantity);
		return new ResponseEntity<CartItem>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "delete/{cartItemId}", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> delete(@PathVariable int cartItemId) {
		JSONObject status = cartItemService.delete(cartItemId);
		return new ResponseEntity<JSONObject>(status, HttpStatus.OK);
	}
}
