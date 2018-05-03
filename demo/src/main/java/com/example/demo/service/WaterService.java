package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.respository.ClothTypeRepository;

@Service
public class WaterService {

	@Autowired
	private ClothTypeRepository ct_repository;

	public void getList() {
		// TODO Auto-generated method stub
		System.out.println(ct_repository.getListLeftJoinCloth());
	}

}
