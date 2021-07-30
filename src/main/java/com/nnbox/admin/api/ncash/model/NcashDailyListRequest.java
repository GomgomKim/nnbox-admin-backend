package com.nnbox.admin.api.ncash.model;

import com.nnbox.admin.common.model.ListRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NcashDailyListRequest extends ListRequest {
      // 구분
      @ApiModelProperty(value = "일차감 구분(1: 리스비, 2: 대출 상환, 3:산재 보험비)", dataType = "Integer", example = "1", required = false, hidden = false)
      private Integer kind;
}