package com.dbs.aop.SpringAOPDemo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class LogAspect {
	public LogAspect() {
		System.out.println("LogAspect constructor");
	}
	@Before("execution(public * com.dbs.aop.SprinAOPDemo.EmpService.setCname(..))")
	public void BeforeAdvice() {
		System.out.println("Before Advice applied");
	}
}
