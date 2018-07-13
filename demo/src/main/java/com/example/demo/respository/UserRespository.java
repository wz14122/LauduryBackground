package com.example.demo.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

import io.lettuce.core.dynamic.annotation.Param;

public interface UserRespository extends JpaRepository<User, String> {

	List<User> findByUsernameAndPassword(String username, String password);
	
	Optional<User> findByUsername(String username);
	
	@Modifying
	@Query(value = "update User set failLoginTimes = failLoginTimes + '1' where userId = ?1")
	void addFailTimes(@Param("userId") String userId);

}
