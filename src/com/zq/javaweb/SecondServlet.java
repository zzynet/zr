package com.zq.javaweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet implements Servlet {

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
		System.out.println("The second Servlet init...");

//		获取Servlet的初始化参数
		String user = config.getInitParameter("user");
		System.out.println("User:  " + user);

		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name + "::" + value);
		}

		String servletname = config.getServletName();
		System.out.println("servlet name is :" + servletname);

//   获取web应用上下文对象

		ServletContext servletContext = config.getServletContext();

		String driver = servletContext.getInitParameter("driver");
		System.out.println("Driver: " + driver);

		Enumeration<String> contextNames = servletContext.getInitParameterNames();
		while (contextNames.hasMoreElements()) {
			String name = contextNames.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println("Context " + name + "::" + value);
		}

//	一个文件在服务器上的绝对路径
		String realPath = servletContext.getRealPath("/note.txt");
		System.out.println(realPath);
		// /Users/zhangqia/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/day0314/note.txt

//		获取当前web的应用名
		String contextPath = servletContext.getContextPath();
		System.out.println(contextPath); /// day0314

//
		try {
			ClassLoader classloader = getClass().getClassLoader();
			InputStream is = classloader.getResourceAsStream("jdbc.properties");
			System.out.println("1. " + is);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
			System.out.println("2. " + is2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Second Servlet Service!");

	}

}
