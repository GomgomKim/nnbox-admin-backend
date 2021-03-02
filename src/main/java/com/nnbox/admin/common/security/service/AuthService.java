package com.nnbox.admin.common.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import com.nnbox.admin.common.security.token.UserAuthenticationToken;
import com.nnbox.admin.common.utils.SessionUtil;
import com.nnbox.admin.data.mapper.UserMapper;
import com.nnbox.admin.data.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthService {
	
	@Value("${testmode}")
	private boolean testMode;

	@Autowired
	UserMapper userMapper;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public enum AuthenticationCode {
		NAN, INVALID_LOGIN_ID, INVALID_LOGIN_PASSWORD, EXPIRED, SYSTEM_ERROR, EMAIL_CONFIRM_NOT_YET
	}
	
	public Authentication authenticateByUserToken(UserAuthenticationToken authenticationToken) throws Exception {
		if (authenticationToken.isAuthenticated()) {
			return authenticationToken;
		}
		boolean isValid = false;
		User user = new User();
		authenticationToken.setUser(user);
		if ("admin".equals(authenticationToken.getId()) && "nnbox1!".equals(authenticationToken.getPassword())) {
			user.setId("admin");
			isValid = true;
		}
		if ("kimpo".equals(authenticationToken.getId()) && "kimpo1!".equals(authenticationToken.getPassword())) {
			user.setId("kimpo");
			isValid = true;
		}
		if ("tax".equals(authenticationToken.getId()) && "tax1!".equals(authenticationToken.getPassword())) {
			user.setId("tax");
			isValid = true;
		}
		if ("law".equals(authenticationToken.getId()) && "law1!".equals(authenticationToken.getPassword())) {
			user.setId("law");
			isValid = true;
		}
		if (!isValid) {
			authenticationToken.setDetails(AuthenticationCode.INVALID_LOGIN_ID);
			return authenticationToken;
		}
//		User user = userMapper.selectById(authenticationToken.getId());
//		authenticationToken.setUser(user);
//		if (ObjectUtils.isEmpty(user)) {
//			authenticationToken.setDetails(AuthenticationCode.INVALID_LOGIN_ID);
//			return authenticationToken;
//		}
//
//		if (user.getDeleted() == 1) {
//			authenticationToken.setDetails(AuthenticationCode.EXPIRED);
//			return authenticationToken;
//		}
//
//		if (!this.passwordEncoder.matches(authenticationToken.getPassword(), user.getPassword())) {
//			authenticationToken.setDetails(AuthenticationCode.INVALID_LOGIN_PASSWORD);
//			return authenticationToken;
//		}

		authenticationToken.setPassword(null);
		authenticationToken.setAuthenticated(true);
//		user.setPassword(null);
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		SessionUtil.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

		return authenticationToken;
	}
}
