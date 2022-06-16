package com.nt.interceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TradeHandlerInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TradeHandlerInterceptor.preHandle()");
		
		LocalDateTime localDateTime = LocalDateTime.now();
		int hour = localDateTime.getHour();
		System.out.println(hour);
		//System.out.println( request.getRequestURI() );
		//System.out.println( request.getRequestURL() );
		//System.out.println( request.getContextPath() );
		System.out.println( request.getServletPath() );
		String servletPath = request.getServletPath();
		if(servletPath.equalsIgnoreCase("/trade")) {
			if(hour<9 || hour>17) {
				//jsp need to place in webaop folder
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/timeout.jsp");
				requestDispatcher.forward(request, response);
				return false;
			}
		}
		return true;
	}
	
/*	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TradeHandlerInterceptor.postHandle()");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TradeHandlerInterceptor.afterCompletion()");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}	*/
	
}//class end
