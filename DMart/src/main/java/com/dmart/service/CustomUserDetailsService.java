package com.dmart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dmart.model.User;
import com.dmart.repository.UserDao;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
		
		Optional<User> userOptional = userDao.findByPhone(phone);
		
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.getRole().toString());
			authorities.add(sga);
			return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), authorities);
			
		} else {
			throw new BadCredentialsException("User doesn't found with this phone numeber: "+phone);
		}
	
	}

}
