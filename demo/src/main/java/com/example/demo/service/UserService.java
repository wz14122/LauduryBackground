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

	public List<User> homePage() {

		return uDao.homePage();
	}
}
