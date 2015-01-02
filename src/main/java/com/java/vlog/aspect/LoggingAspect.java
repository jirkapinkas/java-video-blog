package com.java.vlog.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before(value = "execution(* com.java.vlog..*.*(..))")
	public void logService(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String arguments = Arrays.toString(joinPoint.getArgs());
		logger.info("Called method: " + signature + " with arguments " + arguments);
	}
}
