package com.nnbox.admin.api.authentication.model;

import com.nnbox.admin.common.security.service.AuthService.AuthenticationCode;
import com.nnbox.admin.data.model.AdminUser;

import lombok.Data;

@Data
public class AuthenticationResponse {
	Boolean result;
	AuthenticationCode reason;
	AdminUser adminUser;
}
