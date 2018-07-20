package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ConsumptionDao;
import com.example.demo.entity.Consumption;
import com.example.demo.entity.Goods;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class ConsumptionService {

	@Autowired
	private ConsumptionDao dao;
	
	public void order(String order) {
		
		JSONArray jsonArray = JSONArray.fromObject(order);
		Object o=jsonArray.get(0);
        JSONObject jsonObject2=JSONObject.fromObject(o);
        Goods good=(Goods)JSONObject.toBean(jsonObject2, Goods.class);
        System.out.println("good:"+good);
	}
	
	public Consumption save(Consumption entity) {
		return dao.save(entity);
	}
}
