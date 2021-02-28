package com.nnbox.admin.common.security.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;
import com.nnbox.admin.common.security.service.AuthService;
import com.nnbox.admin.common.security.token.UserAuthenticationToken;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	AuthService authService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			return authService.authenticateByUserToken((UserAuthenticationToken) authentication);
		} catch (AuthenticationException e) {
			throw e;
		} catch (Exception e) {
			throw new BasicException(ErrorCode.COMMON_UNAUTHORIZED, e.getMessage());
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UserAuthenticationToken.class.isAssignableFrom(authentication);
	}

}

