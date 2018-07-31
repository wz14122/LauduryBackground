package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.moudle.MyException;
import com.example.demo.moudle.Result;
import com.example.demo.moudle.ResultEnum;
import com.example.demo.service.CustomerService;
import com.example.demo.utils.ResultUtil;

@RestController
@RequestMapping(value = "/cc")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping(value = "/customer")
	public Result save(@Valid Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new MyException(ResultEnum.FORM_INCOMPLETE);
		}
		return ResultUtil.success(service.save(customer));
	}
	
	@DeleteMapping(value = "/customer/{id}")
	public Result deleteById(@PathVariable(value = "id") int id) {
		service.deleteById(id);
		return ResultUtil.success();
	}

	@PutMapping(value = "/customer")
	public Result update(@Valid Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new MyException(ResultEnum.FORM_INCOMPLETE);
		}
		return ResultUtil.success(service.update(customer));
	}

	@GetMapping(value = "/customer/{id}")
	public Result find(@PathVariable(value = "id") int id) {
		return ResultUtil.success(service.findById(id));
	}

	@GetMapping(value = "/customer")
	public Result findByCustomerName(@RequestParam(value = "customerName") String customerName) {
		return ResultUtil.success(service.findByCustomerName(customerName));
	}
	
	@GetMapping(value = "/customers")
	public Result findAll() {
		return ResultUtil.success(service.findAll());
	}
}
