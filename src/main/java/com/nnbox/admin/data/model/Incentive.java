package com.nnbox.admin.data.model;

import java.util.Date;

import lombok.Data;

@Data
public class Incentive {
    private Integer idx;

    private String incenMonth;

    private Date incenDate;

    private Byte incenPayed;

    private Integer defaultCnt;

    private Integer deliveryCnt;

    private Integer defaultDeliveryPrice;

    private Integer manageIncenAmount;

    private Integer frIncenAmount;

    private Integer totalIncenAmount;
    
    // rider
    private String staffName;
    
    private String staffPhone;
    
    private Integer basicDeliveryPrice;
    
    private Integer staffLevel;
}