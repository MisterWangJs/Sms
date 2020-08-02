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
		//���������ת����HTTPЭ���ʽ���������
		HttpServletRequest req = (HttpServletRequest)request;
		
		//���session����
		HttpSession session = req.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		//�жϵ�ǰ������û��Ƿ�û�е�¼
		if(loginUser == null){
			//����Ӧ����ת����HTTPЭ���ʽ����Ӧ����
			HttpServletResponse resp = (HttpServletResponse)response;
			
			//����û�û�е�¼����ͨ���ض���ķ�ʽ��ת��login.jsp
			String context = req.getContextPath();
			resp.sendRedirect(context + "/login.jsp");
			return;
		}
		
		//����Ѿ���¼��������ͨ������������ת��Ҫ���ʵ���Դ
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {

	}

}
