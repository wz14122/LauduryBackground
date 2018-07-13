package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserLogin;
import com.example.demo.respository.UserLoginRepository;

@Service
public class UserLoginDao {

	@Autowired
	private UserLoginRepository repository;
	
	public UserLogin save(UserLogin entity) {
		return repository.save(entity);
	}
}
