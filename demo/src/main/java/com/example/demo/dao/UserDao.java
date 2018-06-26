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

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return uRespository.findAll();
	}

	public User save(User user) {
		User u = uRespository.save(user);
		return u;
	}
	
	public User findById(int id) {
		return uRespository.findById(id).orElse(null);
	}

}
