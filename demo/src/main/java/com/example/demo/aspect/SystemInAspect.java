package com.example.demo.aspect;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.entity.Role;
import com.example.demo.entity.UserRole;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserRoleService;
import com.example.demo.utils.EnOrDeContext;
import com.example.demo.utils.EnOrDeFactory;
import com.example.demo.utils.EnOrDecryption;
import com.example.demo.utils.ResultUtil;
import com.example.demo.utils.DictionaryUtil;

/**
 * @author wz 这里进行权限管理
 */
@Aspect
@Component
public class SystemInAspect {

	private final static Logger logger = Logger.getLogger(SystemInAspect.class);
	
	@Autowired
	private UserRoleService urService;
	
	@Autowired
	private RoleService roleService;
	
	@Pointcut("execution(* com.example.demo.controller..*(..))")
	public void cut() {

	}

	@Around("cut()")
	public Object checkLoginStatus(ProceedingJoinPoint pjp) throws Throwable {
		// 接收到请求，记录请求内容

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String token = (String) request.getSession().getAttribute("token");
		System.out.println("从session获取" + token);
		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(pjp.getArgs()));

		String method = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
		Object obj = pjp.proceed();

		if (method.equals("com.example.demo.controller.LoginController.login")) {
			return obj;
		}
		if (token == null || token.isEmpty()) {
			return ResultUtil.error(-1, "用户未登录");
		}
		if (!checkPermission(token, method)) {
			return ResultUtil.error(-1, "用户权限不足");
		}

		return obj;
	}

	private boolean checkPermission(String token, String method) {
		
		EnOrDeContext base64 = this.getContext("Base64");
		String idWithSalt = base64.decode(token);
		String[] id = idWithSalt.split(DictionaryUtil.SALT_STRING);
		
		String user_id = base64.decode(id[0]);
		List<UserRole> userRoles = urService.findByUId(user_id);
		for (UserRole userRole : userRoles) {
			this.getRole(userRole);
		}
		System.out.println(userRoles);
		
		return false;
	}
	
	private Role getRole(UserRole userRole) {
		roleService.findByUserRole(userRole);
		return null;
	}
	
	private EnOrDeContext getContext(String method) {
		EnOrDeFactory factory = new EnOrDeFactory();
		EnOrDecryption cryption = factory.getInstance(method);
		EnOrDeContext operate = new EnOrDeContext(cryption);
		return operate;
	}

}
