package com.example.demo.aspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

import com.example.demo.entity.Function;
import com.example.demo.entity.Role;
import com.example.demo.entity.RoleFunction;
import com.example.demo.entity.UserRole;
import com.example.demo.modle.MyException;
import com.example.demo.modle.ResultEnum;
import com.example.demo.service.FunctionService;
import com.example.demo.service.RoleFunctionService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserRoleService;
import com.example.demo.utils.DictionaryUtil;
import com.example.demo.utils.EnOrDeContext;
import com.example.demo.utils.EnOrDeFactory;
import com.example.demo.utils.EnOrDecryption;
import com.example.demo.utils.ResultUtil;

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

	@Autowired
	private RoleFunctionService roleFunService;

	@Autowired
	private FunctionService funService;

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

		String classMethod = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
		String httpMehtod = request.getMethod();
		Object obj = pjp.proceed();
		
		System.out.println(classMethod);
		
		if (classMethod.equals("com.example.demo.controller.LoginController.login")) {
			return obj;
		}
		if (classMethod.equals("com.example.demo.controller.LoginController.register")) {
			return obj;
		}
		if (token == null || token.isEmpty()) {
			return ResultUtil.error(-1, "用户未登录");
		}
		if (!checkPermission(token, classMethod, httpMehtod)) {
			return ResultUtil.error(-1, "用户权限不足");
		}

		return obj;
	}

	/**
	 * 权限校验
	 * 
	 * @param token
	 * @param method
	 * @return
	 */
	private boolean checkPermission(String token, String method, String httpMehtod) {

		// 解密后合理性判断
		EnOrDeContext base64 = this.getContext("Base64");
		String idWithSalt = base64.decode(token);
		String[] id = idWithSalt.split(DictionaryUtil.SALT_STRING);
		if (id.length <= 0) {
			this.log("error", "token不符合设计规范，高度可能受到攻击");
			throw new MyException(ResultEnum.ILLEGAL_ACCESS);
		}

		// 通过user_id查询角色，1对多
		String userId = base64.decode(id[0]);
		List<UserRole> userRoles = urService.findByUId(userId);

		for (UserRole userRole : userRoles) {
			List<Function> list = this.getFunction(userRole);
			for (Function function : list) {

				if (function != null && function.getFunctionUrl().equals(method)
						&& function.getMethod().equals(httpMehtod)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 通过用户角色UserRole，找到功能Function
	 * 
	 * @param userRole
	 * @return
	 */
	private List<Function> getFunction(UserRole userRole) {
		ArrayList<Function> list = new ArrayList<>(10);
		Optional<Role> role = roleService.findByUserRole(userRole);
		List<RoleFunction> roleFunctions = role.map(r -> roleFunService.findByRoleId(r.getRoleId()))
				.orElseThrow(() -> new MyException(ResultEnum.SYSTEM_ERROR));
		for (RoleFunction roleFunction : roleFunctions) {
			list.add(funService.findById(roleFunction.getFunctionId()).orElse(null));
		}
		return list;
	}

	private EnOrDeContext getContext(String method) {
		EnOrDeFactory factory = new EnOrDeFactory();
		EnOrDecryption cryption = factory.getInstance(method);
		EnOrDeContext operate = new EnOrDeContext(cryption);
		return operate;
	}

	private void log(String type, Object message) {
		switch (type) {
		case "info":
			logger.info(message);
			break;
		case "error":
			logger.error(message);
			break;
		default:
			throw new MyException(ResultEnum.ILLEGAL_ARGUMENT);
		}
	}

}
