package com.nnbox.admin.data.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Withdraw {
	  // IDX
	  @ApiModelProperty(value = "IDX", dataType = "Integer", example = "1", required = false, hidden = true)
	  private Integer idx;

	  @ApiModelProperty(value = "요청 유저(라이더) IDX", dataType = "Integer", example = "1", required = false, hidden = true)
	  private Integer userIdx;

	  // 은행
	  @ApiModelProperty(value = "은행", dataType = "String", example = "냠냠은행")
	  private String bank;

	  // 계좌번호
	  @ApiModelProperty(value = "계좌번호", dataType = "String", example = "111-111-1111")
	  private String bankAccount;

	  // 예금주
	  @ApiModelProperty(value = "예금주", dataType = "String", example = "소유주")
	  private String depositor;

	  // 요청 일자
	  @ApiModelProperty(value = "요청 일자", dataType = "LocalDateTime")
	  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	  private LocalDateTime reqDate;

	  // 상태(1: 요청, 2: 처리 완료, 3: 취소)
	  @ApiModelProperty(value = "상태(1: 요청, 2: 처리 완료, 3: 취소)", dataType = "Integer", example = "2")
	  private Integer withdrawStatus;

	  // 요청 금액
	  @ApiModelProperty(value = "요청 금액", dataType = "Integer", example = "10000")
	  private Integer reqAmount;

	  // 처리 일자
	  @ApiModelProperty(value = "처리 일자", dataType = "LocalDateTime")
	  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	  private LocalDateTime procDate;

	  // 관리자 ID
	  @ApiModelProperty(value = "관리자 ID", dataType = "String", example = "admin")
	  private String adminId;

	  // 메모
	  @ApiModelProperty(value = "메모", dataType = "String", example = "잘 처리됨.")
	  private String memo;
}