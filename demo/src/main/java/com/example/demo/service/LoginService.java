package com.example.demo.service;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.entity.User;
import com.example.demo.entity.UserLogin;
import com.example.demo.entity.UserRole;
import com.example.demo.moudle.MyException;
import com.example.demo.moudle.ResultEnum;
import com.example.demo.utils.DictionaryUtil;
import com.example.demo.utils.EnOrDeContext;
import com.example.demo.utils.EnOrDeFactory;
import com.example.demo.utils.EnOrDecryption;

@Service
public class LoginService {

	@Autowired
	private UserService uService;

	@Autowired
	private UserRoleService urService;

	@Autowired
	private UserLoginService ulService;

	/**
	 * 權限驗證略複雜，後期用戶量大后，可以使用存儲過程實現
	 * @param username
	 * @param password
	 */
	@Transactional
	public void login(String username, String password) {
		// 初始化加密方式，获取请求
		EnOrDeContext base64 = this.getContext("Base64");
		EnOrDeContext SHA_256 = this.getContext("SHA-256");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		// 1.用户存在性校验	2.密码校验
		User user = uService.findByUsername(username).orElseThrow(() -> new MyException(ResultEnum.NO_USER));
		if(!SHA_256.encode(password).equals(user.getPassword())) {
			uService.addFailTimes(user.getUserId());
			throw new MyException(ResultEnum.PASSWORD_ERROR);
		}
		
		// 记录登录相关信息
		UserLogin userLogin = new UserLogin();
		userLogin.setUserId(user.getUserId());
		userLogin.setLoginIp(request.getRemoteAddr());
		userLogin.setLoginDate(new Date());
		//userLogin.setLoginDate(System.);
		ulService.save(userLogin);
		

		// 否则加密用户ID后封装到Session
		String userId = user.getUserId();
		String token = base64.encode(base64.encode(userId) + DictionaryUtil.SALT_STRING);
		request.getSession().setAttribute("token", token);

	}

	/**
	 * 后期加入用户角色，不过登录界面的注册本来就应该对应着推广用户，可以直接写死
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws CloneNotSupportedException
	 */
	@Transactional
	public User save(String username, String password, String description) throws CloneNotSupportedException {

		// 用户存在性判断
		if (this.findByUsername(username)) {
			throw new MyException(ResultEnum.USER_REPEAT);
		}

		// 添加新用户
		EnOrDeContext SHA_256 = this.getContext("SHA-256");
		User user = uService.save(new User(username, SHA_256.encode(password)));
		UserRole userRole = new UserRole(user.getUserId(), 1, description);
		UserRole userRole2 = (UserRole) userRole.clone();
		userRole2.setRoleId(2);
		urService.save(userRole);
		urService.save(userRole2);
		return user;
	}

	/**
	 * @param method
	 *            策略名称
	 * @return 获得策略
	 */
	private EnOrDeContext getContext(String method) {
		EnOrDeFactory factory = new EnOrDeFactory();
		EnOrDecryption cryption = factory.getInstance(method);
		EnOrDeContext operate = new EnOrDeContext(cryption);
		return operate;
	}

	private boolean findByUsername(String username) {
		Optional<User> user = uService.findByUsername(username);
		return user.isPresent();
	}
}
