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
	
	@ApiModelProperty(value = "VAN", dataType = "String", example = "12345354325435", required = false)
	private String vanNumber;
}
