package com.nnbox.admin.data.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Ncash {
	  // IDX
	  @ApiModelProperty(value = "IDX", dataType = "Integer", example = "1", required = false, hidden = true)
	  private Integer idx;
	  
	  // 유저 아이디
	  @ApiModelProperty(value = "유저 아이디", dataType = "String", example = "userId")
	  private String userId;
	  
	  // 유저 이름
	  @ApiModelProperty(value = "유저 이름", dataType = "String", example = "김냠냠")
	  private String userName;
	  
	  // 유형(1: 라이더, 2: 매장)
	  @ApiModelProperty(value = "유형(1: 라이더, 2: 매장)", dataType = "Integer", example = "1")
	  private Integer userType;
	  
	  // 유저 잔액
	  @ApiModelProperty(value = "유저 잔액", dataType = "Integer", example = "0")
	  private Integer nCash;
	  
	  // 생성 일자
	  @ApiModelProperty(value = "생성 일자", dataType = "LocalDateTime")
	  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	  private LocalDateTime createDate;
	  
	  // 카테고리
	  @ApiModelProperty(value = "카테고리", dataType = "String", example = "category")
	  private String category;
	  
	  // 메모(카테고리 명)
	  @ApiModelProperty(value = "메모(카테고리 명)", dataType = "String", example = "memo")
	  private String categoryKr;

	  // 금액
	  @ApiModelProperty(value = "금액", dataType = "Integer", example = "10000")
	  private Integer ncashDelta;

	  // 관리자 ID
	  @ApiModelProperty(value = "관리자 ID", dataType = "String", example = "admin")
	  private String adminId;

}