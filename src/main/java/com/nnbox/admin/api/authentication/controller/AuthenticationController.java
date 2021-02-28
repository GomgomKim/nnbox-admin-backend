package com.nnbox.admin.api.authentication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.authentication.model.AuthenticationRequest;
import com.nnbox.admin.api.authentication.model.AuthenticationResponse;
import com.nnbox.admin.api.authentication.service.AuthenticationService;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;
import com.nnbox.admin.common.security.token.UserAuthenticationToken;
import com.nnbox.admin.common.utils.SessionUtil;

@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	AuthenticationService authenticationService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public AuthenticationResponse login(@Valid @RequestBody AuthenticationRequest loginRequest, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
		
		UserAuthenticationToken token = (UserAuthenticationToken)authenticationManager.authenticate(new UserAuthenticationToken(loginRequest.getId(), loginRequest.getPassword(), null, false));
//		return authenticationService.postLogin(token, loginRequest);
		AuthenticationResponse response = new AuthenticationResponse();
		response.setResult(token.isAuthenticated());
		return response;
		
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = "application/json")
	public void logout() throws Exception {
		SessionUtil.invalidate();
	}
}
