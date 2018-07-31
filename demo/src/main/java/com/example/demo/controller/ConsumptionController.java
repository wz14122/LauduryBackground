package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.moudle.Result;
import com.example.demo.service.ConsumptionService;
import com.example.demo.utils.ResultUtil;

@RestController
@RequestMapping(value = "/consumption")
public class ConsumptionController {

	@Autowired
	private ConsumptionService service;

	@PostMapping(value = "/order")
	public Result order(@RequestParam(value = "order", required = true) String order,
			@RequestParam(value = "suggestDate") String suggestDate, @RequestParam(value = "remark") String remark) {
		System.out.println(order);
		service.order(order, suggestDate, remark);
		return ResultUtil.success();
	}
	
	@GetMapping(value = "/order")
	public Result order() {
		return ResultUtil.success(service.findAll());
	}
	
	@GetMapping(value = "/ordersWithCondition")
	public Result getOrdersWithCondition(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "localDate") String localDate) {
		return ResultUtil.success(service.getOrdersWithCondition(username, localDate));
	}
}
