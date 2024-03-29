package com.nnbox.admin.data.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NcashDaily {
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
	  
	  // 구분
	  @ApiModelProperty(value = "구분", dataType = "String", example = "리스료")
	  private String kind;
	  
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
	  @ApiModelProperty(value = "생성 일자", dataType = "LocalDateTime")
	  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	  private LocalDateTime createDate;
	  
	  // 주민번호
	  @ApiModelProperty(value = "주민번호", dataType = "String", example = "주민번호")
	  private String registrationNumber;
	  
	  // 연락처
	  @ApiModelProperty(value = "연락처", dataType = "String", example = "연락처")
	  private String phone;
}