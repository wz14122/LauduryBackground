package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class HomeController {

	@Autowired
	private UserService uService;

	@GetMapping(value = "/home")
	public List<User> homePage() {
		System.out.println("点紧s缺");
		return uService.homePage();
	}
}
