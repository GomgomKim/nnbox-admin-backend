package com.nnbox.admin.data.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DepositLog{
    @ApiModelProperty(value = "유저 아이디", dataType = "String", example = "rider03", required = true, hidden = false)
    private String userId;

    @ApiModelProperty(value = "지급일시", dataType = "String", example = "2021-06-01", required = true, hidden = false)
    private String createDate;
    
    @ApiModelProperty(value = "지급금액", dataType = "Integer", example = "10000", required = true, hidden = false)
    private Integer sendAmount;
    
    @ApiModelProperty(value = "카테고리", dataType = "String", example = "FRAN", required = true, hidden = false)
    private String category;
}