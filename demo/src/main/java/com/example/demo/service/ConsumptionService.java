package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ConsumptionDao;
import com.example.demo.entity.Consumption;
import com.example.demo.moudle.ConsumptionType;
import com.example.demo.utils.DateUtil;

@Service
public class ConsumptionService {

	@Autowired
	private ConsumptionDao dao;

	@Autowired
	private GoodsService gService;

	@Transactional
	public void order(String order, String suggestDate, String remark) {

		Consumption consumption = new Consumption();
		consumption.setConsumptionDate(DateUtil.getToday());
		consumption.setSuggestDate(DateUtil.getDayByNums(Integer.parseInt(suggestDate)));
		// TODO 因为可能不是所有人都喜欢添加微信，因此可能有的用户，连微信号都没，
		//可以参考麦德龙，没有会员的用户，是一个临时用户
		consumption.setCustomerId(1);
		consumption.setRemark(remark);
		consumption.setType(ConsumptionType.CLEANING.getType());

		// 订单表存储
		Consumption c = dao.save(consumption);

		// 商品表存储
		gService.saveAllFromJSONArray(order, c);

		// TODO 向用户发送清单，小票数据，需要订单号，和商品明细
	}

	public Consumption save(Consumption entity) {
		return dao.save(entity);
	}
	
	public List<Consumption> findAll(){
		return dao.findAll();
	}
}
