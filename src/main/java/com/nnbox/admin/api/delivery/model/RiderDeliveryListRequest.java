package com.nnbox.admin.api.delivery.model;

import java.util.Date;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiderDeliveryListRequest extends ListRequest {
	@ApiModelProperty(value = "라이더 이름", dataType = "String", example = "1", required = false)
	private Integer riderName;

	@ApiModelProperty(value = "월(month)", dataType = "Date", example = "2021-01", required = false)
	private Date searchMonth;
}