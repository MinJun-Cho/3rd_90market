package com.googongmarket.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import com.googongmarket.domain.MemberVO;

public class LoginoutInterceptor implements HandlerInterceptor {

	@Resource(name = "loginMember")
	@Lazy
	private MemberVO loginMember;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("loginMember", loginMember);
		
		return true;
	}
	
}
