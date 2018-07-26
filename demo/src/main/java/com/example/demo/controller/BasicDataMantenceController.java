package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.moudle.Result;
import com.example.demo.service.BasicDataMantenceService;
import com.example.demo.utils.ResultUtil;

/**
 * @author wz
 * 基础数据维护
 */
@RestController
@RequestMapping(value = "/bdm")
public class BasicDataMantenceController {
	
	@Autowired
	private BasicDataMantenceService service;
	
	@GetMapping(value = "/allClothMsg")
	public Result allClothMsg() {
		return ResultUtil.success(service.allClothMsg());
	}
	
	@GetMapping(value = "/colors")
	public Result allColors() {
		return ResultUtil.success(service.allColor());
	}
	
	@PostMapping(value = "/color")
	public Result addColor(@RequestParam(value = "colorName", required = true) String colorName) {
		return ResultUtil.success(service.addColor(colorName));
	}
	
}
