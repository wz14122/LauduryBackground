package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.respository.ClothTypeRepository;

@Service
public class WaterService {

	@Autowired
	private ClothTypeRepository ct_repository;

	public List<String> getList() {
		return ct_repository.getListLeftJoinCloth();
	}

}
