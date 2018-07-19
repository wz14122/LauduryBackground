package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ClothType;
import com.example.demo.respository.ClothTypeRepository;

@Service
public class ClothTypeDao {

	@Autowired
	private ClothTypeRepository repository;

	public List<ClothType> findAll() {
		return repository.findAll();
	}
}
