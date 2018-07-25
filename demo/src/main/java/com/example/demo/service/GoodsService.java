package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GoodsDao;
import com.example.demo.entity.Consumption;
import com.example.demo.entity.Goods;
import com.example.demo.utils.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class GoodsService {

	@Autowired
	private GoodsDao dao;
	
	public List<Goods> saveAll(List<Goods> list) {
		return dao.saveAll(list);
	}

	public List<Goods> saveAllFromJSONArray(String jsonArray, Consumption consumption) {
		JSONArray ja = JSONArray.fromObject(jsonArray);
		ArrayList<Goods> entity = new ArrayList<>();
		for (Object object : ja) {
			JSONObject jsonObject2 = JSONObject.fromObject(object);
			Goods good = (Goods) JSONObject.toBean(jsonObject2, Goods.class);
			good.setConsumptionId(consumption.getConsumptionId());
			good.setConsumptionDate(DateUtil.getToday());
			good.setExpectFetchDate(consumption.getSuggestDate());
			good.setHaveFetch(false);
			good.setCustomerId(1);
			System.out.println(good);
			entity.add(good);
		}
		return this.saveAll(entity);
	}
	
	public List<Goods> findByConsumptionId(String consumptionId){
		return dao.findByConsumptionId(consumptionId);
	}
	
	public List<Goods> findByFetchState(boolean state){
		return dao.findByHaveFetch(state);
	}
	
	public void updateGoodsState(String goods) {
		JSONArray ja = JSONArray.fromObject(goods);
		ArrayList<Integer> ids = new ArrayList<>();
		for (Object obj : ja) {
			ids.add(Integer.parseInt((String) obj));
		}
		//修改货物状态
		dao.updateGoodsStateByIds(ids);
	}
}
