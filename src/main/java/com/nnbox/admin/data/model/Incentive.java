package com.nnbox.admin.data.model;

import java.util.Date;

import lombok.Data;

@Data
public class Incentive {
    private Integer idx;

    private Date createDate;

    private Short category;

    private String incenMonth;

    private Date incenDate;

    private Integer userIdx;

    private Short userLevel;

    private Byte isExpect;

    private Byte incenPayed;

    private Date incenPayDate;

    private Integer payedAmount;

    private Integer frSalesIdx;

    private String memo;

    private Integer defaultCnt;

    private Integer deliveryCnt;

    private Integer deliveryPriceSum;

    private Integer defaultDeliveryPrice;

    private Integer manageIncenAmount;

    private Integer frIncenAmount;

    private Integer totalIncenAmount;
}