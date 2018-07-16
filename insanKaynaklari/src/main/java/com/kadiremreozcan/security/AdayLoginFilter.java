package com.kadiremreozcan.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kadiremreozcan.entity.Adays;

@Component
@Scope("session")
public class AdayLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		Adays aday = (Adays) req.getSession().getAttribute("adaySession");
		
		if(req.getRequestURI().contains("login")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("resources")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(aday != null) {
			chain.doFilter(request, response);
			return;
		}else {
			
			res.sendRedirect("login");
		}
		
		chain.doFilter(request, response);	
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
