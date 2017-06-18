package com.npu.universityApp.aspects;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Component
//component:for auto bean reference
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(public * org.npu.universityApp..*.Account*(..))")
	public void allAccountBasedMethods(){	
	}
	
	@Before("execution(public * org.npu.universityApp..*.Account*(..))")
	public void beforeAccountMethods(JoinPoint joinPt){
		logger.debug("Method is called Before Advice " +joinPt.getSignature());
	}

	@After("execution(public * org.npu.universityApp..*.Account*(..))")
	public void afterAccountMethods(JoinPoint joinPt){
		logger.debug("After Advice:" +joinPt.getSignature());
	}
	
	@Around("execution(public * org.npu.universityApp.*.*(..))")
	public void aroundAccountMethods(JoinPoint joinPt){
		logger.debug("Around Advice: " +joinPt.getSignature());
	}
}
