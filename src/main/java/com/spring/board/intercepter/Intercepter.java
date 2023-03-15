package com.spring.board.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Intercepter extends HandlerInterceptorAdapter{
	
	protected final Logger logger = LoggerFactory.getLogger(Interceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		 logger.debug("==================== 로그인 안했으면 다시 돌아가 ====================");
		if(obj==null) {
			response.sendRedirect("/");
			return false;
		}
		return true;
	}
}
