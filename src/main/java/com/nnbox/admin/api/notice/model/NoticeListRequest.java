package com.nnbox.admin.api.notice.model;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeListRequest extends ListRequest {
	  // 제목
      @ApiModelProperty(value = "제목", dataType = "String")
      private String title;
      
      // 시작일
      @ApiModelProperty(value = "시작일", dataType = "String")
      private String startDate;
      
      // 종료일
      @ApiModelProperty(value = "종료일", dataType = "String")
      private String endDate;
}