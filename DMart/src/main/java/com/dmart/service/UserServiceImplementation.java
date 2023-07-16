package com.dmart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmart.exception.UserExistException;
import com.dmart.model.User;
import com.dmart.repository.UserDao;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User registerUser(User user) throws UserExistException {
		Optional<User> userOptional = userDao.findByPhone(user.getPhone());
		
		if(userOptional.isPresent()) {
			throw new UserExistException("User already exist with this phone number!");
		}
		
		
		return userDao.save(user);
	}

}
