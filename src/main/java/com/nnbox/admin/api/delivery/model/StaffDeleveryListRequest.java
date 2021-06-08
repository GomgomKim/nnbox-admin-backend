package com.nnbox.admin.api.delivery.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDeleveryListRequest extends ListRequest {

	@ApiModelProperty(value = "유저(라이더) IDX", dataType = "Integer", example = "1", required = false, hidden = true)
	private Integer userIdx;

	@ApiModelProperty(value = "시작 일자", dataType = "Date", example = "2021-01-01", required = true, hidden = false)
	@JsonFormat(pattern="YYYY-MM-DD")
	private LocalDateTime startDate;

	@ApiModelProperty(value = "종료 일자", dataType = "Date", example = "2021-12-31", required = true, hidden = false)
	@JsonFormat(pattern="YYYY-MM-DD")
	private LocalDateTime endDate;

	@ApiModelProperty(value = "주문 상태", dataType = "Integer", example = "4", required = true, hidden = false)
	private List<Integer> orderStatuses;

}
