package com.nnbox.admin.api.ncash.model;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawListRequest extends ListRequest {
	// 유저 ID
    @ApiModelProperty(value = "유저 ID", dataType = "String", example = "userId")
    private String userId;
    
    // 유저 유형
    @ApiModelProperty(value = "유저 유형(1: 라이더, 2: 가맹점)", dataType = "Integer", example = "1", required = true, hidden = false)
    private Integer userType;
}