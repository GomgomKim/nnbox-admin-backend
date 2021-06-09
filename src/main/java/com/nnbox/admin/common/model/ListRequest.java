package com.nnbox.admin.common.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListRequest {

	@Min(1)
	@Max(100)
	int pageSize = 10;

	@Min(1)
	int pageNum = 1;

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	public int getLimitStart() {
		return (pageNum - 1) * pageSize;
	}
}
