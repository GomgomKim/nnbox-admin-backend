package com.nnbox.admin.api.authentication.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class AuthenticationRequest {
	@NotEmpty
	String id;

	@NotEmpty
	String password;
	
	String deviceId;
	
	String pushToken;
	
	String language;
}
