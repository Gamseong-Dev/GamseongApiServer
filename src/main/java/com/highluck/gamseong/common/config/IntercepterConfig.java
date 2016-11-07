package com.highluck.gamseong.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.highluck.gamseong.common.intercepter.AuthIntercepterHandler;

@Configuration 
@EnableWebMvc 
public class IntercepterConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private AuthIntercepterHandler authIntercepterHandler;
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authIntercepterHandler);
    }
}
