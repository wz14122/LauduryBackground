package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RoleFunction;

public interface RoleFunctionRepository extends JpaRepository<RoleFunction, Integer> {

	List<RoleFunction> findByRoleId(Integer roleId);
}
