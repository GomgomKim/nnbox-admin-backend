package com.nnbox.admin.api.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.authentication.model.AuthenticationRequest;
import com.nnbox.admin.api.authentication.model.AuthenticationResponse;
import com.nnbox.admin.common.security.service.AuthService.AuthenticationCode;
import com.nnbox.admin.common.security.token.UserAuthenticationToken;
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
	UserLoginLogMapper userLoginLogMapper;
	
	public AuthenticationResponse postLogin(UserAuthenticationToken token, AuthenticationRequest loginRequest) throws Exception {
		AuthenticationResponse response = new AuthenticationResponse();
		response.setResult(token.isAuthenticated());

		UserLoginLog userLoginLog = new UserLoginLog();
		log.debug("token: {}", token);
		log.debug("token: {}", token.getUser());
//		log.debug("token: {}", token.getUser().getIdx());
//		userLoginLog.setUserIdx(token.getUser() == null ? 0 : token.getUser().getIdx());
		
		if (!token.isAuthenticated()) {
			response.setReason((AuthenticationCode)token.getDetails());
//			userLoginLog.setResult(((AuthenticationCode)token.getDetails()).name());	
		}
		else {
			token.getUser().setPassword(null);
			token.getUser().setSecurityPassword(null);
			token.getUser().setToken(null);
			token.getUser().setOtpKey(null);
			token.getUser().setOtpUrl(null);
			response.setUser(token.getUser());
			
//			if(loginRequest.getPushToken() != null && !loginRequest.getPushToken().equals(token.getUser().getPushToken())) {
//				User user = new User();
//				user.setIdx(token.getUser().getIdx());
//				user.setPushToken(loginRequest.getPushToken());
//				userMapper.updateByPrimaryKeySelective(user);
//				token.getUser().setPushToken(loginRequest.getPushToken());
//			}

			userLoginLog.setResult("SUCCESS");	
		}
//		userLoginLogMapper.insertSelective(userLoginLog);
		
		return response;
	}
}
