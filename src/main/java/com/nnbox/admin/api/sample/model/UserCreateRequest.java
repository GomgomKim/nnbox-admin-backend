package com.nnbox.admin.api.sample.model;

import lombok.Data;

@Data
public class UserCreateRequest {
	private String id;
	private String password;
}
