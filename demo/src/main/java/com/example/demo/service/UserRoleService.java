package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRoleDao;
import com.example.demo.entity.UserRole;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleDao dao;
	
	public UserRole save(UserRole userRole) {
		return dao.save(userRole);
	}
}
