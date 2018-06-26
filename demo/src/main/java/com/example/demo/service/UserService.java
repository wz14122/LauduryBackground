package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao uDao;

	public List<User> findAll() {

		return uDao.findAll();
	}
	
	public User save(User user){
		User u = uDao.save(user);
		return u;
	}
	
	public User findById(int id) {
		return uDao.findById(id);
	}
}
