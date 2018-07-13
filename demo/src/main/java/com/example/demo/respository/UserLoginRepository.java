package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

}
