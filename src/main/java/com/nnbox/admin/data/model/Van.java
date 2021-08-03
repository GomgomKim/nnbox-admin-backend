package com.nnbox.admin.data.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class Van {
    // IDX
	private Integer idx;

	// 유저 IDX
	@ApiModelProperty(value = "유저 IDX", dataType = "Integer", example = "1")
    private Integer userIdx;

	// 생성 날짜
	@ApiModelProperty(value = "생성 날짜", dataType = "String", example = "2021-01-01")
    private String createDate;

	// 등록자 타입
	@ApiModelProperty(value = "등록자 타입", dataType = "Integer", example = "1")
    private Integer type;

	// VAN 은행명
	@ApiModelProperty(value = "VAN 은행명", dataType = "String", example = "신한은행/082")
    private String vAccountBank;

	// VAN 계좌번호
	@ApiModelProperty(value = "VAN 계좌번호", dataType = "String", example = "110-123-123456")
    private String vAccountNumber;

	// VAN 예금주
	@ApiModelProperty(value = "VAN 예금주", dataType = "String", example = "냠냠박스")
    private String vAccountDeposor;
	
	// 사업자 등록증
	@ApiModelProperty(value = "사업자 등록중", dataType = "String", example = "URL")
    private String businessRegistration;

	// 대표 등록 번호
	@ApiModelProperty(value = "대표자 신분증", dataType = "String", example = "URL")
    private String representativeRegistrationNumber;

	// 통장 사본
	@ApiModelProperty(value = "통장 사본", dataType = "String", example = "URL")
    private String accountCopy;

	// 영업 신고증
	@ApiModelProperty(value = "영업 신고증", dataType = "String", example = "URL")
    private String businessCertification;

	// 대표자 핸드폰 통신사
	@ApiModelProperty(value = "대표자 핸드폰 통신사", dataType = "String", example = "URL")
    private String representativePhoneAgency;

    // 매장 외부 사진
 	@ApiModelProperty(value = "매장 외부 사진", dataType = "String", example = "URL")
    private String outsidePhoto;

 	// 매장 내부 사진
  	@ApiModelProperty(value = "매장 내부 사진", dataType = "String", example = "URL")
    private String insidePhoto;

  	// 법인등기부등본
  	@ApiModelProperty(value = "법인등기부등본", dataType = "String", example = "URL")
    private String corporateRegistration;

  	// 법인인감증명서
   	@ApiModelProperty(value = "법인인감증명서", dataType = "String", example = "URL")
    private String corporateCertificate;

    // 주주 명부
  	@ApiModelProperty(value = "주주 명부", dataType = "String", example = "URL")
    private String shareholderRegister;

    // 사용 인감계
  	@ApiModelProperty(value = "사용 인감계", dataType = "String", example = "URL")
    private String useSeal;

    // 본사 유선
  	@ApiModelProperty(value = "본사 유선", dataType = "String", example = "URL")
    private String phone;
}