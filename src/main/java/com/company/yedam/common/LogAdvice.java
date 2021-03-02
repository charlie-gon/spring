package com.company.yedam.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice { // AOP_210302
	@Pointcut("execution(* com.company.yedam..*Impl.*(..))")
	public void allpointcut() {}
	@Before("allpointcut()")
	public void printlog(JoinPoint jp) {
		// 메서드명
		String name = jp.getSignature().getName();
		// 매개변수
		Object[] args = jp.getArgs();
		
		System.out.println("[공통로그] before 적용 \n" 
							+ " / " + name 
							+ " / " + (args != null && args.length>0 ? args[0] : "no before exists") );
	}
}
