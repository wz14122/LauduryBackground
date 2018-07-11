package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserRole;
import com.example.demo.respository.UserRoleRepository;

@Service
public class UserRoleDao {

	@Autowired
	private UserRoleRepository repository;

	public UserRole save(UserRole entity) {
		return repository.save(entity);
	}

	public List<UserRole> findByUId(String userId) {
		
		return repository.findByUserId(userId);
	}
}
