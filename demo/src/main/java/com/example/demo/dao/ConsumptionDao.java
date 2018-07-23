package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Consumption;
import com.example.demo.respository.ConsumptionRepository;

@Service
public class ConsumptionDao {

	@Autowired
	private ConsumptionRepository repository;

	public Consumption save(Consumption entity) {
		return repository.save(entity);
	}
	
	public List<Consumption> findAll(){
		return repository.findAll(); 
	}
	
}
