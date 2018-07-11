package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoleFunction;
import com.example.demo.respository.RoleFunctionRepository;

@Service
public class RoleFunctionDao {

	@Autowired
	private RoleFunctionRepository repository;
	
	public Optional<RoleFunction> findById(int id){
		return repository.findById(id);
	}
	
	public List<RoleFunction> findByRoleId(int roleId) {
		return repository.findByRoleId(roleId);
	}
}
