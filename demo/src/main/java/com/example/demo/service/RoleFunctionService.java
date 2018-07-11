package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleFunctionDao;
import com.example.demo.entity.RoleFunction;

@Service
public class RoleFunctionService {

	@Autowired
	private RoleFunctionDao dao;

	public Optional<RoleFunction> findById(int id) {
		return dao.findById(id);
	}

	public List<RoleFunction> findByRoleId(int roleId) {
		return dao.findByRoleId(roleId);
	}
}
