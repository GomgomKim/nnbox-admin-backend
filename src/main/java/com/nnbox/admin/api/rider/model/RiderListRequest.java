package com.nnbox.admin.api.rider.model;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiderListRequest extends ListRequest {
	@ApiModelProperty(value = "라이더 이름", dataType = "String", example = "rider03", required = false)
	private String riderName;
}