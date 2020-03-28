package com.zq.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Request is coming...");
		System.out.println(res);
		
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		String interesting =req.getParameter("interesting");
		System.out.println(user + ":" + password + ":" + interesting); //只能获取checkbox选择的第一个值
		
		String[] interesting1 = req.getParameterValues("interesting");
		for(String interest: interesting1) {
			System.out.println("-->" + interest);
		}
		
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String[] values = req.getParameterValues(name);
			for (String value: values) {
//			String value = req.getParameter(name);
			System.out.println(name+ ":" + value);
			}
		}
		
		Map<String, String[]> map =req.getParameterMap();
		for(Map.Entry<String, String[]> entry: map.entrySet()) {
			System.out.println(entry.getKey() + ":" + Arrays.asList(entry.getValue()));
		}
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println(requestURI);
		
		String method = httpServletRequest.getMethod();
		System.out.println(method);
		
		String query = httpServletRequest.getQueryString();
		System.out.println(query);
		
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(servletPath);
		
		//
		PrintWriter out = res.getWriter();
		out.println("Hello World!");//打印到浏览器
		
		//设置响应的内容类型：
		res.setContentType("application/msword");
		out.println("将内容打印到word文档");
	}
	

}
