package com.nnbox.admin.data.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BikeMaintenance {
    private Integer idx;

    @ApiModelProperty(value = "바이크 인덱스", dataType = "Integer", example = "1", required = false)
    private Integer bikeIdx;
    
    @ApiModelProperty(value = "정비 날짜", dataType = "String", example = "2021-06-21", required = false)
    private String startDate;

    @ApiModelProperty(value = "정비사항", dataType = "String", example = "타이어 교체", required = false)
    private String content;

    @ApiModelProperty(value = "정비사유", dataType = "String", example = "주행 중 넘어짐", required = false)
    private String reason;

    @ApiModelProperty(value = "소요기간", dataType = "Integer", example = "1", required = false)
    private Integer totalHours;

    @ApiModelProperty(value = "정비자", dataType = "String", example = "김길동", required = false)
    private String worker;

    @ApiModelProperty(value = "바이크 종류", dataType = "String", example = "PCX", required = false)
    private String modelName;

    @ApiModelProperty(value = "바이크 넘버", dataType = "String", example = "10가2345", required = false)
    private String bikeNumber;
}