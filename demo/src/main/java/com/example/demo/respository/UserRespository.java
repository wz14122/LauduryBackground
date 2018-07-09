package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRespository extends JpaRepository<User, String> {

	List<User> findByUsernameAndPassword(String username, String password);

}
