package com.nnbox.admin.api.van.model;

import java.util.List;

import com.nnbox.admin.common.model.ListResponse;
import com.nnbox.admin.data.model.Van;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VanListResponse extends ListResponse {
	List<Van> vans;
}
