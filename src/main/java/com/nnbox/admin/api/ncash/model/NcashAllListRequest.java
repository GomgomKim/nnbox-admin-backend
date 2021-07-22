package com.nnbox.admin.api.ncash.model;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NcashAllListRequest extends ListRequest {
	  // 유저 아이디
	  @ApiModelProperty(value = "아이디", dataType = "String", example = "knowend")
	  private String userId;
	  
	  // 카테고리
      @ApiModelProperty(value = "카테고리", dataType = "String")
      private String category;  
}