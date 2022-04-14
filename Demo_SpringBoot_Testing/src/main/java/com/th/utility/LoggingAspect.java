package com.th.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.th.exception.ThbsBankException;

@Component
@Aspect
public class LoggingAspect {

	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	@Before("execution(* com.th.service.*Impl.*(..))")
	public void before() throws ThbsBankException {
		LOGGER.info("Before advice called.");
	}

	@After("execution(* com.th.service.*Impl.*(..))")
	public void after() throws ThbsBankException {
		LOGGER.info("After advice called.");
	}

	@AfterReturning("execution(* com.th.service.*Impl.*(..))")
	public void afterReturning() throws ThbsBankException {
		LOGGER.info("After returning advice called.");
	}

	@AfterThrowing(pointcut = "execution(* com.th.service.*Impl.*(..))", throwing = "exception")
	public void afterThrowing(ThbsBankException exception) throws ThbsBankException {
		LOGGER.error(exception.getMessage(), exception);
	}

}