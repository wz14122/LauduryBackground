package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.moudle.MyException;
import com.example.demo.moudle.Result;
import com.example.demo.moudle.ResultEnum;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultUtil;

@RestController
public class HomeController {

	@Autowired
	private UserService uService;

	@GetMapping(value = "/home")
	public Result homePage() {
		return ResultUtil.success(uService.findAll());
	}

	/* 交互方式获取方式 */

	/**
	 * 查
	 * 
	 * @param id
	 * @return 查詢結果
	 * @throws MyException
	 */
	@GetMapping(value = "/user/{id}")
	public Result findById(@PathVariable("id") String id) throws MyException {
		User user = Optional.ofNullable(uService.findById(id))
				.orElseThrow(() -> new MyException(ResultEnum.ENTITY_NOTFOUND));
		return ResultUtil.success(user);
	}

	@PostMapping(value = "/type1")
	public Result type1(@RequestParam(value = "phoneNum", required = true) String phoneNum,
			@RequestParam(value = "userName") String userName) {
		return null;
	}
	
	@PostMapping(value = "/type2")
	public String type2(@RequestBody User user){
		System.out.print(user.getPassword());
		return "success"; 
	}


	/**
	 * 查
	 * 
	 * @return 全部结果
	 */
	@GetMapping(value = "/users")
	public Result findAll() {
		List<User> list = Optional.ofNullable(uService.findAll())
				.orElseThrow(() -> new MyException(ResultEnum.ENTITY_NOTFOUND));
		return ResultUtil.success(list);
	}

	/**
	 * 增
	 * 
	 * @param user
	 * @param bindingResult
	 * @return user
	 */
	@PostMapping(value = "/user")
	public Result addUser(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new MyException(ResultEnum.FORM_INCOMPLETE);
		}
		return ResultUtil.success(uService.save(user));
	}

	/**
	 * 改
	 * 
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@PutMapping(value = "/user")
	public Result modifyUser(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new MyException(ResultEnum.FORM_INCOMPLETE);
		}
		return ResultUtil.success(uService.save(user));
	}
}
