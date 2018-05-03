package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.WaterService;

@RestController
@RequestMapping(value = "/water")
public class WaterController {

	@Autowired
	private WaterService service;
	
	@PostMapping(value = "/cloth")
	public String cloth() {
		return "success";
	}
	
	@GetMapping(value = "/cloth")
	public String getList() {
		service.getList();
		return "success";
	}
}
