package com.nnbox.admin.data.model;

import java.util.Date;

import com.nnbox.admin.common.constants.CashLogCategoryCode;

import lombok.Data;

@Data
public class CashLog {
    private Integer idx;

    private Date createDate;

    private CashLogCategoryCode category;

    private Integer userIdx;

    private Integer sendAmount;

    private String memo;

    private String userId;

    private Integer userType;

    private String adminId;

    private Integer receiveIdx;

    private String receiveId;

    private Integer beforeNcash;

    private Integer ncashDelta;

    private Integer branchIdx;
}