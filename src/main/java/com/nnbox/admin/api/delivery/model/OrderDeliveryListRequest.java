package com.nnbox.admin.api.delivery.model;

import java.util.Date;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDeliveryListRequest extends ListRequest {
	@ApiModelProperty(value = "라이더 이름", dataType = "String", example = "1", required = false)
	private String riderName;
	
	@ApiModelProperty(value = "가맹점 전화번호", dataType = "String", example = "1", required = false)
	private String frPhone;
	
	@ApiModelProperty(value = "가맹점 이름", dataType = "String", example = "1", required = false)
	private String frName;

	@ApiModelProperty(value = "시작일", dataType = "Date", example = "2021-01-11", required = false)
	private Date startDate;
	
	@ApiModelProperty(value = "종료일", dataType = "Date", example = "2021-01-11", required = false)
	private Date endDate;
}