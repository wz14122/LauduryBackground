package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleDao;
import com.example.demo.entity.Role;
import com.example.demo.entity.UserRole;
import com.example.demo.modle.MyException;
import com.example.demo.modle.ResultEnum;

@Service
public class RoleService {

	@Autowired
	private RoleDao dao;

	public Optional<Role> findByUserRole(UserRole userRole) {
		Integer roleId = Optional.ofNullable(userRole.getRoleId())
				.orElseThrow(() -> new MyException(ResultEnum.SYSTEM_ERROR));
		return dao.findById(roleId);
	}
}
