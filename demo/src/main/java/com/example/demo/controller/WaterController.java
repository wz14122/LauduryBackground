package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.moudle.Result;
import com.example.demo.service.WaterService;
import com.example.demo.utils.ResultUtil;

@RestController
@RequestMapping(value = "/water")
public class WaterController {

	@Autowired
	private WaterService service;
	
	@PostMapping(value = "/cloth")
	public Result cloth(@RequestParam String reqMap) {
		System.out.println(reqMap);
		System.out.println("我进来了");
		return ResultUtil.success(service.getList());
	}
	
	@PostMapping(value = "/test")
	public Result cloths(@RequestBody Map<String,Object> reqMap) {
		System.out.println(reqMap);
		System.out.println("我进来了");
		return ResultUtil.success(service.getList());
	}
	
	@GetMapping(value = "/cloth")
	public Result getList() {
		return ResultUtil.success(service.getList());
	}
}
