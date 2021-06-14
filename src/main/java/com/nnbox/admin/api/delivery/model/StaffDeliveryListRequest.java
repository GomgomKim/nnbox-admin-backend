package com.nnbox.admin.api.delivery.model;

import java.util.List;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDeliveryListRequest extends ListRequest {
	@ApiModelProperty(value = "직원 이름", dataType = "String", example = "아무개", required = false)
	private String staffName;
	
	@ApiModelProperty(value = "직원 연락처", dataType = "String", example = "010-1234-5678", required = false)
	private String staffPhone;
	
	@ApiModelProperty(value = "월별 검색", dataType = "String", example = "2021-01", required = false)
	private String searchMonth;
	
	@ApiModelProperty(value = "인센티브 종류", required = true)
	private List<Integer> categories;
	
}