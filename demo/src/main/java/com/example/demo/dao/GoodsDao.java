package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Goods;
import com.example.demo.respository.GoodsRepository;

@Service
public class GoodsDao {

	@Autowired
	private GoodsRepository repository;

	public Goods save(Goods entity) {
		return repository.save(entity);
	}

	public List<Goods> savAll(List<Goods> entities) {
		return repository.saveAll(entities);
	}
}
