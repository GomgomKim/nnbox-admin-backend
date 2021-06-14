package com.nnbox.admin.data.model;

import java.util.Date;

import lombok.Data;

@Data
public class Incentive {
    private Integer idx;
    
    // 인센티브 지급 달
    private String incenMonth;

    private Date incenDate;

    // 인센티브 지급 여부
    private Byte incenPayed;
    
    // 기본건수
    private Integer defaultCnt;

    // 배달건수
    private Integer deliveryCnt;

    // 기본배달료
    private Integer defaultDeliveryPrice;

    // 관리 인센티브
    private Integer manageIncenAmount;

    // 가맹점 인센티브
    private Integer frIncenAmount;

    // 추가 인센티브
    private Integer totalIncenAmount;
    
    // 직원 정보
    // 이름
    private String staffName;
    
    // 휴대폰 번호
    private String staffPhone;
    
    // 기본 배달료
    private Integer basicDeliveryPrice;
    
    // 직급
    private Integer staffLevel;
}