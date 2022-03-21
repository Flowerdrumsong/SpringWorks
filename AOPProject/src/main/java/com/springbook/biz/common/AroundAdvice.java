package com.springbook.biz.common;

//import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	// p around
//	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("[BEFORE] 비즈니스 메소드 수행 전에 처리할 내용...");
//		Object returnObj=pjp.proceed();//포인트컷을 수행하라는 의미 (시점)
//		System.out.println("[AFTER] 비즈니스 메소드 수행 후에 처리할 내용...");
//		return returnObj;
//	}
	// p198 around
//	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
//		String method=pjp.getSignature().getName();
//		StopWatch stopWatch=new StopWatch();
//		stopWatch.start();
//		
//		Object obj=pjp.proceed();
//		
//		stopWatch.stop();
//		System.out.println(method+"() 메소드 수행에 걸린 시간: "+ stopWatch.getTotalTimeMillis()+"(ms)초");
//		
//		return obj;
//	}
	
	//p210
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method=pjp.getSignature().getName();
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();
		
		Object obj=pjp.proceed();
		
		stopWatch.stop();
		System.out.println(method+"() 메소드 수행에 걸린 시간: "+ stopWatch.getTotalTimeMillis()+"(ms)초");
		
		return obj;
		
	}
}
