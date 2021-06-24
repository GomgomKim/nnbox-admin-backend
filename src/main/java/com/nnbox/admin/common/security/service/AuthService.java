package com.nnbox.admin.common.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.nnbox.admin.api.authentication.model.AdminAuthMenuResponse;
import com.nnbox.admin.common.security.token.UserAuthenticationToken;
import com.nnbox.admin.common.utils.SessionUtil;
import com.nnbox.admin.data.mapper.AdminUserMapper;
import com.nnbox.admin.data.mapper.MenuMapper;
import com.nnbox.admin.data.model.AdminUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthService {
	
	@Value("${testmode}")
	private boolean testMode;

	@Autowired
	AdminUserMapper adminUserMapper;
	@Autowired
	MenuMapper menuMapper;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public enum AuthenticationCode {
		NAN, INVALID_LOGIN_ID, INVALID_LOGIN_PASSWORD, EXPIRED, SYSTEM_ERROR, EMAIL_CONFIRM_NOT_YET
	}
	
	public Authentication authenticateByUserToken(UserAuthenticationToken authenticationToken) throws Exception {
		if (authenticationToken.isAuthenticated()) {
			return authenticationToken;
		}
		AdminUser adminUser = adminUserMapper.selectById(authenticationToken.getId());
		authenticationToken.setAdminUser(adminUser);
		if (ObjectUtils.isEmpty(adminUser)) {
			authenticationToken.setDetails(AuthenticationCode.INVALID_LOGIN_ID);
			return authenticationToken;
		}
		
		log.debug("test 1: "+authenticationToken.getPassword());
		log.debug(adminUser.getPassword());
		
//		if (!this.passwordEncoder.matches(authenticationToken.getPassword(), adminUser.getPassword())) {
//			authenticationToken.setDetails(AuthenticationCode.INVALID_LOGIN_PASSWORD);
//			return authenticationToken;
//		}
		List<AdminAuthMenuResponse> userMenuAuthes = menuMapper.getAllAdminAuthMenu(authenticationToken.getAdminUser().getIdx());
		adminUser.setAdminAuth(userMenuAuthes);
		authenticationToken.setAdminUser(adminUser);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authenticationToken.setAuthorities(authorities);
		authenticationToken.setPassword(null);
		authenticationToken.setAuthenticated(true);
//		user.setPassword(null);
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		SessionUtil.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());

		return authenticationToken;
	}
}
