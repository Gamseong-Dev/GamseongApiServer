package com.highluck.gamseong.common.intercepter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.highluck.gamseong.common.annotation.HighAuth;
import com.highluck.gamseong.model.value.AuthValue;
import com.highluck.gamseong.repository.AuthRepository;
import com.highluck.gamseong.service.app.AuthService;

@Component
public class AuthIntercepterHandler extends WebContentInterceptor{
	
	@Autowired
	private AuthRepository authRepository;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
		//HandlerMethod handlerMethod = (HandlerMethod) handler;
		if (handler instanceof HandlerMethod) {
			HighAuth highAuth = ((HandlerMethod) handler).getMethodAnnotation(HighAuth.class);
			
	        if(highAuth == null) {
	        	return super.preHandle(request, response, handler);
	        }
	         else {
	            //TODO 추가작업
	    		AuthValue value = new AuthValue();
	    		value.setToken(request.getHeader("s-token"));
	    		value.setId(request.getHeader("s-Id"));
	    
	    		if(1 > authRepository.authByToken(value)) return false;
	    		else return super.preHandle(request, response, handler);		
	        }
		}
		else {
			return super.preHandle(request, response, handler);
		}
    }   
}
