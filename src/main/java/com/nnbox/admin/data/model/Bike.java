package com.nnbox.admin.data.model;

import java.util.Date;

import lombok.Data;

@Data
public class Bike {
    private Integer idx;

    private Date createDate;

    private String bikeNumber;

    private Short bikeStatus;

    private String modelName;

    private String maker;

    private Date makeDate;

    private Short modelYear;

    private Integer mileage;

    private String memo;
}