package com.nnbox.admin.common.security.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(new BasicException(ErrorCode.COMMON_UNAUTHORIZED)));
		response.getWriter().flush();
		response.getWriter().close();
	}
}
