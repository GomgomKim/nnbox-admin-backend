package com.nnbox.admin.api.ncash.model;

import com.nnbox.admin.data.model.Log;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NcashCreateRequest extends Log {
  @ApiModelProperty(value = "받는 유저(라이더 or 가맹점) IDX", dataType = "Integer", example = "2")
  private Integer receiveUserIdx;
  
  @ApiModelProperty(value = "아이디", dataType = "String", example = "knowend")
  private String userId;

  @ApiModelProperty(value = "보낼 금액(ncash)", dataType = "Integer", example = "1")
  private Integer ncashAmount;
  
  @ApiModelProperty(value = "관리자 개인 메모", dataType = "String", example = "메모")
  private String ncashMemo;
}