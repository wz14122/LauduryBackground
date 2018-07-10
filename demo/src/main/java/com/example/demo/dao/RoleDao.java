package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.respository.RoleRepository;

@Service
public class RoleDao {

	@Autowired
	private RoleRepository repository;
	
	public Optional<Role> findById(int roleId) {
		return repository.findById(roleId);
	}
}
