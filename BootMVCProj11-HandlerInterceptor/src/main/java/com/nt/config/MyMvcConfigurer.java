package com.nt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptor.TradeHandlerInterceptor;

@Component
public class MyMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("MyMvcConfigurer.addInterceptors()");
		registry.addInterceptor(new TradeHandlerInterceptor());
	}

}//class end

