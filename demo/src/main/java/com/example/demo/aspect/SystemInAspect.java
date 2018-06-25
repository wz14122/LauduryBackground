package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemInAspect {
	
	@Pointcut("execution(* com.example.demo.controller..*(..))")
	public void cut() {
		
	}
	
	@Around("cut()")
	public Object checkLoginStatus(ProceedingJoinPoint pjp) throws Throwable {
		
		Object obj = pjp.proceed();
		return obj;
	}
	
}
