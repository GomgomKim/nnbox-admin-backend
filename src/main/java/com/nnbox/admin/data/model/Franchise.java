package com.nnbox.admin.data.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Franchise {
	@ApiModelProperty(value = "가맹점 인덱스", dataType = "Integer", example = "1", required = true)
	private Integer userIdx;
	
	@ApiModelProperty(value = "지점 이름", dataType = "String", example = "지점명", required = false)
	private String branchName;
	
	@ApiModelProperty(value = "가맹점 이름", dataType = "String", example = "가맹점명", required = false)
	private String frName;
	
	@ApiModelProperty(value = "가맹점 도로명 주소", dataType = "String", example = "한글비석로", required = false)
	private String addr1;
	
	@ApiModelProperty(value = "가맹점 지번주소", dataType = "String", example = "서울시 논현동 111-22", required = false)
	private String addr2;
	
	@ApiModelProperty(value = "가맹점 상세주소", dataType = "String", example = "3층", required = false)
	private String addr3;
	
	@ApiModelProperty(value = "PG사용여부", dataType = "String", example = "100", required = false)
	private String tidNormalRate;
	
	@ApiModelProperty(value = "가맹점번호", dataType = "String", example = "02-222-3333", required = false)
	private String frPhone;
	
	@ApiModelProperty(value = "PG월렛ID", dataType = "String", example = "W1625627221abe4bef", required = false)
	private String walletId;
	
	@ApiModelProperty(value = "밴결제ID", dataType = "String", example = "", required = false)
	private String tidNormal;
	
	@ApiModelProperty(value = "PG결제ID", dataType = "String", example = "", required = false)
	private String tidPrepay;
	
	@ApiModelProperty(value = "사업자번호", dataType = "String", example = "8358701726", required = false)
	private String businessNumber;
	
	@ApiModelProperty(value = "대표자명", dataType = "String", example = "홍길동", required = false)
	private String ownerName;
	
	@ApiModelProperty(value = "ID", dataType = "String", example = "sady7", required = false)
	private String userId;
	
	@ApiModelProperty(value = "이메일", dataType = "String", example = "sady7@naver.com", required = false)
	private String userEmail;
	
	@ApiModelProperty(value = "폰", dataType = "String", example = "01111111111", required = false)
	private String userPhone;

	
	@ApiModelProperty(value = "가상계좌은행", dataType = "String", example = "우리,020", required = false)
	private String vAccountBank;
	
	@ApiModelProperty(value = "가상계좌번호", dataType = "String", example = "21939293092", required = false)
	private String vAccountNumber;
	
	@ApiModelProperty(value = "가상계좌예금주", dataType = "String", example = "냠냠-화통식당", required = false)
	private String vAccountDepositor;
	
	@ApiModelProperty(value = "가맹비", dataType = "Integer", example = "1000", required = false)
	private Integer ncashDelta;
}
