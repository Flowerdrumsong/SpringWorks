package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// p151-153
@Service
@Aspect // Aspect=Pointcut+Advice
public class LogAdvice {
	// p201
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
				
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPontcut() {}

	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
