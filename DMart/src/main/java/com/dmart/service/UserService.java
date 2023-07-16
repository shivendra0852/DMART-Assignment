package com.dmart.service;

import com.dmart.exception.UserExistException;
import com.dmart.exception.UserNotFoundException;
import com.dmart.model.User;

public interface UserService {
	public User registerUser(User user) throws UserExistException;
}
