package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.moudle.Result;
import com.example.demo.service.GoodsService;
import com.example.demo.utils.ResultUtil;

@RestController
@RequestMapping(value = "/gc")
public class GoodsController {

	@Autowired
	private GoodsService gs;
	
	@GetMapping(value = "/goods/{id}")
	public Result findByConsumptionId(@PathVariable("id") String id) {
		
		return ResultUtil.success(gs.findByConsumptionId(id));
	}
	
	@PutMapping(value = "/goods")
	public Result updateGoodsState(@RequestParam(value = "goods", required = true) String goods) {
		gs.updateGoodsState(goods);
		return ResultUtil.success();
	}
	
	@GetMapping(value = "/state/{state}")
	public Result findByFetchState(@PathVariable("state") boolean state) {
		return ResultUtil.success(gs.findByFetchState(state));
	}
}
