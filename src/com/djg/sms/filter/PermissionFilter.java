package com.djg.sms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.djg.sms.domain.User;

public class PermissionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//把请求对象转换成HTTP协议格式的请求对象
		HttpServletRequest req = (HttpServletRequest)request;
		
		//获得session对象
		HttpSession session = req.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		//判断当前请求的用户是否没有登录
		if(loginUser == null){
			//把响应对象转换成HTTP协议格式的响应对象
			HttpServletResponse resp = (HttpServletResponse)response;
			
			//如果用户没有登录，则通过重定向的方式跳转到login.jsp
			String context = req.getContextPath();
			resp.sendRedirect(context + "/login.jsp");
			return;
		}
		
		//如果已经登录，则允许通过过滤器，跳转到要访问的资源
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {

	}

}
