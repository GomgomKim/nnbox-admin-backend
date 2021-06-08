package com.nnbox.admin.api.authentication.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AuthenticationRequest {
	@NotEmpty
	@ApiModelProperty(value = "ID", dataType = "String", example = "knowend")
	String id;

	@NotEmpty
	String password;

//	String deviceId;

	@ApiModelProperty(value = "pushToken", dataType = "String", example = "", hidden = true)
	String pushToken;

//	String language;
}
