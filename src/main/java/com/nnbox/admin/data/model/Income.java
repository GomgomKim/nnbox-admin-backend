package com.nnbox.admin.data.model;

import java.util.Date;

import lombok.Data;

@Data
public class Income {
    private Integer idx;

    private Date createDate;

    private String incomeMonth;

    private Date incomeDate;

    private Integer userIdx;

    private Integer incomeAmount;

    private String memo;
    
    // 라이더관련
    // 라이더 이름
    private String riderName;
    
    // 라이더 연락처
    private String riderPhone;
    
    // 라이더 그룹
    private Integer riderGroup;
    
    // 수수료 방식
    private Integer feeType;
    
    // 수수료
    private Integer feeAmount;
    
    // 배달요금
    private Integer deliveryPrice;
}