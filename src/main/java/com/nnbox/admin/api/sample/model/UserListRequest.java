package com.nnbox.admin.api.sample.model;

import com.nnbox.admin.common.model.ListRequest;

import lombok.Data;

@Data
public class UserListRequest extends ListRequest {
	private String searchId;
}
