package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

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
	
	public void addFailTimes(String userId) {
		uRespository.addFailTimes(userId);
	}

	public User findById(String id) {
		return uRespository.findById(id).orElse(null);
	}

	public List<User> findByUAP(String username, String password) {
		// TODO Auto-generated method stub
		return uRespository.findByUsernameAndPassword(username, password);
	}

	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return uRespository.findByUsername(username);
	}

}
