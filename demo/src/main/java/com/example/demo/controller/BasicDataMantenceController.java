package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Color;
import com.example.demo.moudle.MyException;
import com.example.demo.moudle.Result;
import com.example.demo.moudle.ResultEnum;
import com.example.demo.service.BasicDataMantenceService;
import com.example.demo.utils.ResultUtil;

/**
 * @author wz 基础数据维护
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
	public Result addColor(@Valid Color color, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new MyException(ResultEnum.FORM_INCOMPLETE);
		}
		return ResultUtil.success(service.addColor(color.getType()));
	}

	@PostMapping(value = "/cloth")
	public Result addCloth(@RequestParam(value = "type", required = true) int type,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "price", required = true) double price) {
		return ResultUtil.success(service.addCloth(type, name, price));
	}

}
