package com.nnbox.admin.api.sample.model;

import java.util.List;

import com.nnbox.admin.common.model.ListResponse;
import com.nnbox.admin.data.model.User;

import lombok.Data;

@Data
public class UserListResponse extends ListResponse {
	List<User> users;
}
