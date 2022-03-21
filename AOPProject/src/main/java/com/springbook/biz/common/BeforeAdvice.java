package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import org.aspectj.lang.JoinPoint;

@Service
@Aspect
public class BeforeAdvice {
	// p178 before
//	public void beforeLog() {
//		System.out.println("[사전처리] 비즈니스 로직 수행 전 동작");
//	}
	
	// p191
//	public void beforeLog(JoinPoint jp) {
//		String method =jp.getSignature().getName();
//		Object[] args=jp.getArgs();
//		
//		System.out.println("[사전처리]"+method+"() 메소드 ARGS 정보: "+args[0].toString());
//	}
	// p204
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method=jp.getSignature().getDeclaringTypeName();
		Object[] args=jp.getArgs();
		
		System.out.println("[사전처리] "+method+"() 메소드 args 정보: "+ args[0].toString());
	}

}
