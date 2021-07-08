package com.nnbox.admin.api.fr.model;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrListRequest extends ListRequest {
	@ApiModelProperty(value = "가맹점 이름", dataType = "String", example = "frName", required = false)
	private String frName;
	
	@ApiModelProperty(value = "지점 이름", dataType = "String", example = "지점명", required = false)
	private String branchName;
}