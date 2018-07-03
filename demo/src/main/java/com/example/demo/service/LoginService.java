package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.entity.User;
import com.example.demo.modle.MyException;
import com.example.demo.modle.ResultEnum;
import com.example.demo.utils.EnOrDeContext;
import com.example.demo.utils.EnOrDeFactory;
import com.example.demo.utils.EnOrDecryption;

@Service
public class LoginService {

	@Autowired
	private UserService uService;

	public void login(String username, String password) {
		// password加密后查询
		EnOrDeContext base64 = this.getContext("Base64");
		List<User> users = uService.findByUAP(username, base64.encode(password));

		// 不存在则抛用户不存在，否则加密用户ID后封装到Session
		User user = Optional.ofNullable(users.get(0)).orElseThrow(() -> new MyException(ResultEnum.NO_USER));
		int user_id = user.getU_Id();
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		request.getSession().setAttribute("token", base64.encode(user_id + ""));

	}

	/**
	 * 后期加入用户角色，不过登录界面的注册本来就应该对应着推广用户，可以直接写死
	 * @param username
	 * @param password
	 * @return 
	 */
	@Transactional
	public User save(String username, String password) {
		EnOrDeContext SHA_256 = this.getContext("SHA-256"); 
		User user = new User(username, SHA_256.encode(password));
		return uService.save(user);
	}
	
	/**
	 * @param method 策略名称
	 * @return 获得策略
	 */
	private EnOrDeContext getContext(String method) {
		EnOrDeFactory factory = new EnOrDeFactory();
		EnOrDecryption cryption = factory.getInstance(method);
		EnOrDeContext operate = new EnOrDeContext(cryption);
		return operate;
	}
}
