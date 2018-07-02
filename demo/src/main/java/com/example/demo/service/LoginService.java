package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.entity.User;
import com.example.demo.modle.MyException;
import com.example.demo.modle.ResultEnum;

@Service
public class LoginService {

	@Autowired
	private UserService uService;
	
	public void login(String username,String password) {
		List<User> users = uService.findByUAP(username,password);
		
		
		User user = Optional.ofNullable(users.get(0)).orElseThrow(()-> new MyException(ResultEnum.NO_USER));
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		request.setAttribute("token", "123456789");
		request.getSession().setAttribute("token", user);
		
		System.out.println(users);
	}
}
