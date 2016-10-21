package com.highluck.gamseong.common.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.highluck.gamseong.model.value.AuthValue;
import com.highluck.gamseong.repository.AuthRepository;

@Component
public class FilterConfig implements Filter{

	@Autowired
	private AuthRepository authRepository;
	
	@Override
	public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
	/*	
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		AuthValue value = new AuthValue();
		value.setToken(httpServletRequest.getHeader("s-token"));
		value.setId(httpServletRequest.getHeader("s-Id"));
		
		if(1 > authRepository.authByToken(value)) 
			response.getWriter().write("인증실패");
		*/
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
