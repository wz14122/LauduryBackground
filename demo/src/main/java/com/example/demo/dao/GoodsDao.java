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

	public List<Goods> saveAll(List<Goods> entities) {
		return repository.saveAll(entities);
	}

	public List<Goods> findByConsumptionId(String consumptionId) {
		return repository.findByConsumptionId(consumptionId);
	}

	public List<Goods> findByHaveFetch(boolean state) {
		return repository.findByHaveFetch(state);
	}
}
