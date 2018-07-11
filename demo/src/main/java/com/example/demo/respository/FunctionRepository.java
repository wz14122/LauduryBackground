package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Function;

public interface FunctionRepository extends JpaRepository<Function, Integer> {

}
