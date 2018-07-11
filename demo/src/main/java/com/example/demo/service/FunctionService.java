package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FunctionDao;
import com.example.demo.entity.Function;

@Service
public class FunctionService {

	@Autowired
	private FunctionDao dao;
	
	public Optional<Function> findById(int functionId){
		return dao.findById(functionId);
	}
}
