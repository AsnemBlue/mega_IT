package com.tj.ex2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class ProxyClass2 {
//	@Pointcut("within(com.tj.ex2.*)")
//	private void aroundM() {}
//	@Around("aroundM()")
	@Around("within(com.tj.ex2.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("☆ 공통기능 around Advice 시작");
		String signatureName = joinPoint.getSignature().toShortString();
		System.out.println(signatureName+" 기능 시작");
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			System.out.println(signatureName+" 기능 종료 ☆ ");
		} 
	}
	@Before("within(com.tj.ex2.Worker2)")
	public void beforeAdvice() {
		System.out.println("핵심기능 수행 전 beforeAdvice()");
	}
	@After("execution(* com.tj.ex2.Student2.*())")
	public void afterAdvice() {
		System.out.println("핵심기능 수행 후 afterAdvice()");
	}
	@AfterThrowing("within(com.tj.ex2.Student2)")
	public void afterthrowing() {
		System.out.println("예외가 발생한 핵심기능 수행 후 afterthrowing()");
	}
	@AfterReturning("execution(public void com.tj.ex2.Student2.getStudentInfo())")
	public void afterReturing() {
		System.out.println("예외가 발생되지 않는 핵심기능 수행후 afterReturing()");
	}
}














