package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	// List<UserRole> findByUId(String u_Id);

	@Query(value = "select ur from UserRole ur where ur.u_Id=?1")
	List<UserRole> findByUId(String u_Id);

}
