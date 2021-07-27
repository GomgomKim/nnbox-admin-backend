package com.nnbox.admin.data.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Withdraw {
	  // IDX
	  @ApiModelProperty(value = "IDX", dataType = "Integer", example = "1", required = false, hidden = true)
	  private Integer idx;
	  
	  // 유저 IDX
	  @ApiModelProperty(value = "요청 유저(라이더) IDX", dataType = "Integer", example = "1", required = false, hidden = true)
	  private Integer userIdx;

	  // 유저 아이디
	  @ApiModelProperty(value = "유저 아이디", dataType = "String", example = "userId")
	  private String userId;
	  
	  // 유저 이름
	  @ApiModelProperty(value = "유저 이름", dataType = "String", example = "김냠냠")
	  private String userName;
	  
	  // 은행
	  @ApiModelProperty(value = "은행", dataType = "String", example = "냠냠은행")
	  private String bank;

	  // 계좌번호
	  @ApiModelProperty(value = "계좌번호", dataType = "String", example = "111-111-1111")
	  private String bankAccount;

	  // 예금주
	  @ApiModelProperty(value = "예금주", dataType = "String", example = "소유주")
	  private String depositor;
	  
	  // 요청 금액
	  @ApiModelProperty(value = "요청 금액", dataType = "Integer", example = "10000")
	  private Integer ncashDelta;

	  // 메모
	  @ApiModelProperty(value = "메모", dataType = "String", example = "잘 처리됨.")
	  private String memo;
	  
	  // 생성 일자
	  @ApiModelProperty(value = "생성 일자", dataType = "String")
	  private String createDate;
}