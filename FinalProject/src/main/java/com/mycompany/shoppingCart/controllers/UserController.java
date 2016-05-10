package com.mycompany.shoppingCart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.shoppingCart.bo.User;
import com.mycompany.shoppingCart.services.UserService;

@RestController
@RequestMapping (value = "/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable String userName) {
	       User user = userService.getUser(userName);
		   return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
