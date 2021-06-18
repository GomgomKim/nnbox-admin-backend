package com.nnbox.admin.api.notice.model;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeListRequest extends ListRequest {
	@ApiModelProperty(value = "라이더 이름", dataType = "String", example = "1", required = false)
	private String title;
	
	@ApiModelProperty(value = "시작일", dataType = "String", example = "2021-01-11", required = false)
	private String startDate;
	
	@ApiModelProperty(value = "종료일", dataType = "String", example = "2021-01-11", required = false)
	private String endDate;
}