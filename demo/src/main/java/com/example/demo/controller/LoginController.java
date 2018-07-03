package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modle.Result;
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
	
	@GetMapping(value = "/register")
	public Result register(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		return ResultUtil.success(service.save(username, password));
	}
}
