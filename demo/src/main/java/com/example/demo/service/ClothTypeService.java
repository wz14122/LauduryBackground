package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClothTypeDao;
import com.example.demo.entity.ClothType;

@Service
public class ClothTypeService {

	@Autowired
	private ClothTypeDao dao;
	
	public List<ClothType> findAll(){
		return dao.findAll();
	}
}
