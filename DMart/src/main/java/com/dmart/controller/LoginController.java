package com.dmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmart.exception.UserNotFoundException;
import com.dmart.model.User;
import com.dmart.repository.UserDao;

@RestController
@RequestMapping("/DMart")
public class LoginController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("users/login")
    public ResponseEntity<User> getLoggedInUserDetailsHandler(Authentication auth) {
        User user = userDao.findByPhone(auth.getName())
                .orElseThrow(() -> new UserNotFoundException("Invalid Username or password"));
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
