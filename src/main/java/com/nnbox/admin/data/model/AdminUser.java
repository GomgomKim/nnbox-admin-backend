package com.nnbox.admin.data.model;

import lombok.Data;

@Data
public class AdminUser {
    private Integer idx;

    private String id;

    private String password;

    private String email;

    private String phone;
}