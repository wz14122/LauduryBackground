package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Color;
import com.example.demo.respository.ColorRepository;

@Service
public class ColorDao {

	@Autowired
	private ColorRepository repository;
	
	public List<Color> findAll(){
		return repository.findAll();
	}
	
	public Color save(Color entity) {
		return repository.save(entity);
	}
	
	public Optional<Color> findByType(String type) {
		return repository.findByType(type);
	}
	
}
