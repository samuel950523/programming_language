package com.mycom.myapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // if omit No Error but No Aspect
@Aspect
public class LogAspect {
	@Pointcut(value="execution(* com.mycom..*.log(..))")
	private void logPointcut(){}
	
	@Before("logPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("[Log: Before] 메서드 이름 : " + signature.getName());
	}
	
	@After("logPointcut()")
	public void AfterLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("[Log: After] 메서드 이름 : " + signature.getName());
	}
}
