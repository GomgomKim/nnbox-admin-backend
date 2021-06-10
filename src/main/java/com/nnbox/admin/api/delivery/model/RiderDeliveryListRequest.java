package com.nnbox.admin.api.delivery.model;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiderDeliveryListRequest extends ListRequest {
	@ApiModelProperty(value = "라이더 이름", dataType = "String", example = "1", required = false)
	private String riderName;
	
	@ApiModelProperty(value = "라이더 연락처", dataType = "String", example = "1", required = false)
	private String riderPhone;
	
	@ApiModelProperty(value = "월별 검색", dataType = "String", example = "2021-01", required = false)
	private String searchMonth;
}
