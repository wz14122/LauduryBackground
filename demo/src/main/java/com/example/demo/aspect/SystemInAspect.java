package com.example.demo.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author wz
 * 这里进行权限管理
 */
@Aspect
@Component
public class SystemInAspect {
	
	private final static Logger logger = Logger.getLogger(SystemInAspect.class);
	
	@Pointcut("execution(* com.example.demo.controller..*(..))")
	public void cut() {
		
	}
	
	@Around("cut()")
	public Object checkLoginStatus(ProceedingJoinPoint pjp) throws Throwable {
        // 接收到请求，记录请求内容
		
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String token = (String) request.getAttribute("token");
        
        System.out.println("直接获取token"+token);
        System.out.println("从session获取"+request.getSession().getAttribute("token"));
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(pjp.getArgs()));
		
        Object obj = pjp.proceed();
        
		return obj;
	}
	
}
