package com.nnbox.admin.api.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.authentication.model.AuthenticationRequest;
import com.nnbox.admin.api.authentication.model.AuthenticationResponse;
import com.nnbox.admin.common.security.service.AuthService.AuthenticationCode;
import com.nnbox.admin.common.security.token.UserAuthenticationToken;
import com.nnbox.admin.data.mapper.AdminUserMapper;
import com.nnbox.admin.data.mapper.UserLoginLogMapper;
import com.nnbox.admin.data.mapper.UserMapper;
import com.nnbox.admin.data.model.UserLoginLog;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticationService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	AdminUserMapper adminUserMapper;
	@Autowired
	UserLoginLogMapper userLoginLogMapper;
	
	
	public AuthenticationResponse postLogin(UserAuthenticationToken token, AuthenticationRequest loginRequest) throws Exception {
		AuthenticationResponse response = new AuthenticationResponse();
		response.setResult(token.isAuthenticated());

		UserLoginLog userLoginLog = new UserLoginLog();
		userLoginLog.setUserIdx(token.getAdminUser() == null ? 0 : token.getAdminUser().getIdx());
		
		if (!token.isAuthenticated()) {
			response.setReason((AuthenticationCode)token.getDetails());
			userLoginLog.setResult(((AuthenticationCode)token.getDetails()).name());	
		}
		else {
			token.getAdminUser().setPassword(null);
			
//			response.setAuthorities(token.getAuthorities());
			response.setAdminUser(token.getAdminUser());
			
//			if(loginRequest.getPushToken() != null && !loginRequest.getPushToken().equals(token.getAdminUser().getPushToken())) {
//				User user = new User();
//				user.setIdx(token.getAdminUser().getIdx());
//				user.setPushToken(loginRequest.getPushToken());
//				userMapper.updateByPrimaryKeySelective(user);
//				token.getAdminUser().setPushToken(loginRequest.getPushToken());
//			}

			userLoginLog.setResult("SUCCESS");	
		}
		userLoginLogMapper.insertSelective(userLoginLog);
		
		return response;
	}
}
