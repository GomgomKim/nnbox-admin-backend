package com.nnbox.admin.api.delivery.model;

import java.util.Date;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiderDeliveryListRequest extends ListRequest {
	@ApiModelProperty(value = "라이더 or 직원 이름", dataType = "String", example = "1", required = false)
	private String userName;
	
	@ApiModelProperty(value = "라이더 or 직원 or 가맹점 전화번호", dataType = "String", example = "1", required = false)
	private String userPhone;
	
	@ApiModelProperty(value = "가맹점 이름", dataType = "String", example = "1", required = false)
	private String frName;

	@ApiModelProperty(value = "월(month)", dataType = "Date", example = "2021-01", required = false)
	private Date searchMonth;
}