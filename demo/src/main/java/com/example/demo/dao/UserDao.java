package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.respository.UserRespository;

@Service
public class UserDao {

	@Autowired
	private UserRespository uRespository;

	public List<User> homePage() {
		// TODO Auto-generated method stub
		return uRespository.findAll();
	}

}
