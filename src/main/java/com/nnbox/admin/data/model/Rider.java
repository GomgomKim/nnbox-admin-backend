package com.nnbox.admin.data.model;

import lombok.Data;

@Data
public class Rider {
    private Integer userIdx;

    private String riderName;

    private Short riderStatus;

    private Short riderLevel;

    private Short deliveryPriceFeeType;

    private Integer deliveryPriceFeeAmount;

    private Integer basicDeliveryPrice;

    private Short monthBasicAmount;

    private Byte managementIncenShouldBePayed;

    private Byte frIncenShouldBePayed;

    private Byte prepaymentIncenShouldBePayed;

    private Integer riderSettingGroupIdx;

    private Integer driverLicenseFileIdx;

    private String driverLicenseNumber;

    private Integer teamManagerIdx;

    private String driverLicenseName;

    private String driverLicenseIssueDate;
    
    private Integer ncash;
}