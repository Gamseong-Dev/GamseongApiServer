package com.highluck.gamseong.common.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highluck.gamseong.common.config.FilterConfig;
import com.highluck.gamseong.model.response.CommonResponse;



@Aspect
@Service
public class CommonResponseAdvice {

	 //private static final Logger logger = LoggerFactory.getLogger(CommonResponseAdvice.class);

	 @Autowired
	 private FilterConfig filter;

	 @Pointcut("@annotation(com.highluck.gamseong.common.annotation.SuccessHigh)")
	 public void pointing() {}

	 @AfterReturning(pointcut = "pointing ()", returning = "successRes")
	 public void afterReturningTargetMethod(JoinPoint thisJoinPoint, CommonResponse successRes) {
		 successRes.setResult("success");
	     filter.chainResponse(successRes);
	 }
	
}
