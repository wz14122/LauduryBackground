package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserLoginDao;
import com.example.demo.entity.UserLogin;

@Service
public class UserLoginService {

	@Autowired
	private UserLoginDao dao;
	
	public UserLogin save(UserLogin userLogin) {
		return dao.save(userLogin);
	}
}
