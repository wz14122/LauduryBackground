package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cloth;
import com.example.demo.respository.ClothRepository;

@Service
public class ClothDao {

	@Autowired
	private ClothRepository repository;
	
	public List<Cloth> findAll(){
		return repository.findAll();
	}

	public List<Cloth> findByClothTypeCode(int clothTypeId) {
		return repository.findByClothTypeCode(clothTypeId);
	}
}
