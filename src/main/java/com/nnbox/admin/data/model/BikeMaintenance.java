package com.nnbox.admin.data.model;

import java.util.Date;

import lombok.Data;

@Data
public class BikeMaintenance {
    private Integer idx;

    private Date startDate;

    private String content;

    private String reason;

    private Integer totalHours;

    private String worker;

    private String modelName;

    private String bikeNumber;
}