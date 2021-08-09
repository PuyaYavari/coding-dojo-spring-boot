package com.assignment.spring.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
@Order(1)
public class APIKeyAuthFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String expextedKey = "";

		expextedKey = "b22ac30e61f624d5d9ecfaec62edc932976e15d2f1599809297f5422ed3b396b";

		String key = req.getHeader("Authorization") == null ? "" : req.getHeader("Authorization");

		if (!DigestUtils.sha256Hex(key).equals(expextedKey)) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.reset();
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		} else {
			chain.doFilter(request, response);
		}

	}

}