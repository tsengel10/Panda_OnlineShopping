package com.panda.onlineshopping.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panda.onlineshopping.entities.AuthToken;
import com.panda.onlineshopping.entities.User;
import com.panda.onlineshopping.services.UserService;

@Controller
@RequestMapping("/")
public class Authentication {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public ResponseEntity<AuthToken> authenticateUser(@RequestBody User user, HttpServletRequest request,
			HttpServletResponse response) {

		User auth_user = userService.authenticateUser(user);
		if (auth_user != null) {
			System.out.println("-----User is not null so we are creating token for user");
			AuthToken token = userService.getActiveAuthTokenByUser(auth_user);
			// Setting all tokens to inactive
			if (token != null)
				userService.setInactiveAuthToken(token);
			// Generate new token for user
			AuthToken newToken = userService.generateTokenForUser(auth_user);
			userService.createAuthToken(newToken);
			System.out.println("---Token created!");
			// Set http header here
			response.setHeader("PandaAuthToken", newToken.getToken());
			System.out.println("---Added to the HTTP Header");
			return new ResponseEntity<AuthToken>(newToken, HttpStatus.OK);
		} else {
			System.out.println("-----User not found and trying to look for token...");
			// check if request has token
			if (request.getHeader("PandaAuthToken") != null && request.getHeader("PandaAuthToken").length() > 0) {
				// if so check token is active or not
				String token = request.getHeader("PandaAuthToken");
				System.out.println("The token is: " + token);
				if (userService.isActiveToken(token)) {
					System.out.println("---Token is active");
					AuthToken tkn = userService.getTokenByToken(token);
					System.out.println("-----Token found and everything is ok...");
					return new ResponseEntity<AuthToken>(tkn, HttpStatus.OK);
				} else {
					System.out.println("-----Token is not active....");
					System.out.println("---Token is NOT active");
					return new ResponseEntity<AuthToken>(HttpStatus.BAD_REQUEST);
				}
			} else {
				System.out.println("----No token at all");
				return new ResponseEntity<AuthToken>(HttpStatus.BAD_REQUEST);
			}
		}

	}

}
