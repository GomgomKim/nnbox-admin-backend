package com.nnbox.admin.data.model;

import java.util.Date;

import lombok.Data;

@Data
public class Notice {
    private Integer idx;

    private String title;

    private String content;

    private Date createDate;

    private Byte deleted;

    private Date deleteDate;

    private Short category;

    private Integer sortOrder;

    private Byte important;

    private Integer branchIdx;
}