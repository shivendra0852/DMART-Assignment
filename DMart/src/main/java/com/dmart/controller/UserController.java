package com.dmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmart.exception.UserExistException;
import com.dmart.model.User;
import com.dmart.service.UserService;

@RestController
@RequestMapping("DMart")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/users/registration")
	public ResponseEntity<User> registerUser(User user) throws UserExistException{
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User res = userService.registerUser(user);
		
		return new ResponseEntity<User>(res, HttpStatus.CREATED);
	}
}
