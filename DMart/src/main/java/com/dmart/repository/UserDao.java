package com.dmart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmart.model.User;

public interface UserDao extends JpaRepository<User, Integer>{
	Optional<User> findByPhone(String phone);
}
