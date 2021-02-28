package com.nnbox.admin.common.utils;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;
import com.nnbox.admin.common.security.token.UserAuthenticationToken;

public class SessionUtil {
	private static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true);
	}

	public static void setAttribute(String name, Object value) {
		session().setAttribute(name, value);
	}

	public static Object getAttribute(String name) {
		return session().getAttribute(name);
	}

	public static void invalidate() {
		session().invalidate();
	}

	public static UserAuthenticationToken getSessionUserToken() throws Exception{
		SecurityContext ctx = (SecurityContext)getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);		
		if (ctx != null && ctx.getAuthentication() instanceof UserAuthenticationToken) {
			UserAuthenticationToken userToken = (UserAuthenticationToken)ctx.getAuthentication();
			return userToken.isAuthenticated() ? userToken: null;
		}else {
			return null;
		}		
	}
}