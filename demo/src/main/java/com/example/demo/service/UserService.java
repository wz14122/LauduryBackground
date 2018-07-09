package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public List<User> findAll() {

		return dao.findAll();
	}

	public User save(User user) {
		User u = dao.save(user);
		return u;
	}

	/**
	 * 通过用户名密码查询用户
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public List<User> findByUAP(String username, String password) {
		return dao.findByUAP(username, password);
	}

	public User findById(String id) {
		return dao.findById(id);
	}

}
