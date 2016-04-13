package com.panda.onlineshopping.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartController {

	@RequestMapping(value = "test/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getTest(@PathVariable int id) {
		System.out.println("TEST:::::::::::::::::::::::::::::::::::::::::::::::");
		return new ResponseEntity<String>("TEST:::::", HttpStatus.OK);
	}
}
