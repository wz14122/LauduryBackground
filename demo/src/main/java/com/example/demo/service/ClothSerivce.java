package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClothDao;
import com.example.demo.entity.Cloth;

@Service
public class ClothSerivce {

	@Autowired
	private ClothDao dao;
	
	public List<Cloth> findAll(){
		return dao.findAll();
	}
}
