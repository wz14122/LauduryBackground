package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.moudle.MyException;
import com.example.demo.moudle.Result;
import com.example.demo.moudle.ResultEnum;
import com.example.demo.service.LoginService;
import com.example.demo.utils.ResultUtil;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@GetMapping(value = "/login")
	public Result login(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		service.login(username, password);
		return ResultUtil.success();
	}

	@PostMapping(value = "/register")
	public Result register(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "description") String description) {
		try {
			return ResultUtil.success(service.save(username, password, description));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			throw new MyException(ResultEnum.SYSTEM_ERROR);
		}
	}

}
