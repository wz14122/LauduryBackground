package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Function;
import com.example.demo.respository.FunctionRepository;

@Service
public class FunctionDao {

	@Autowired
	private FunctionRepository repository;
	
	public Optional<Function> findById(int functionId) {
		return repository.findById(functionId);
	}
}
