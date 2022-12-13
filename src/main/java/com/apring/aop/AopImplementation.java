package com.apring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Configuration
public class AopImplementation {
	
	@Pointcut("execution(public ModelAndView *())")
	public void p1(){};
	
	@Pointcut("execution(public ModelAndView *())")
	public void p2(){};

	
	@Before("p1()")
	public void beforeAdvice() {
		System.out.println("before working...");
	}
	
	@After("p2()")
	public void afterAdvice() {
		System.out.println("after working...");
	}
	
	
	
	
}
