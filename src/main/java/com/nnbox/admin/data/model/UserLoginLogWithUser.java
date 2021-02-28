package com.nnbox.admin.data.model;

import lombok.Data;

@Data
public class UserLoginLogWithUser extends UserLoginLog {
	private String id;
	private String name;
}
