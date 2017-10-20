package com.ibm.cit.EmployeeStatsSpring.filters;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.GenericFilterBean;

import com.ibm.cit.EmployeeStatsSpring.service.UserLoginService;

@Transactional
public class TokenFilter extends HttpServlet {

	private static final String COOKIE_TOKEN_ID = "token_id";
	private static final String SECURED_URL_PREFIX = "secured";
	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED).build();
	@Autowired
	@Qualifier("loginService")
	UserLoginService loginService;
	
	public void doFilter(HttpServletRequest servletRequest, HttpServletRequest servletResponse, FilterChain filter)
			throws IOException, ServletException {
		if (servletRequest.getServletContext().getContextPath().contains(SECURED_URL_PREFIX)) {
			Cookie[] cookies = servletRequest.getCookies();
			Cookie tokenCookie = null;
			tokenCookie = getTokenCookie(cookies);
			if (isTokenCookieValid(tokenCookie)) {
				return;
			}
		

		} else {
			return;
		}
	}
	


	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			Map<String, Cookie> cookies = requestContext.getCookies();
			Cookie tokenCookie = null;
			tokenCookie = getTokenCookie(cookies);
			if (isTokenCookieValid(tokenCookie)) {
				return;
			}
			requestContext.abortWith(ACCESS_DENIED);

		} else {
			return;
		}
	}

	private Cookie getTokenCookie(Cookie[] cookies) {
		javax.servlet.http.Cookie tokenCookie = null;
		if (cookies == null) {
			return tokenCookie;
		}
		for (javax.servlet.http.Cookie cookie:cookies) {
			if (cookie.getName().equals(COOKIE_TOKEN_ID)) {
				tokenCookie = cookie;
				break;
			}
		}
		return tokenCookie;
	}

	private boolean isTokenCookieValid(Cookie tokenCookie) {
		boolean isValid = false;
		isValid = (tokenCookie != null) ? (loginService.isLoginValid(tokenCookie.getValue())) : false;
		return isValid;
	}



}
