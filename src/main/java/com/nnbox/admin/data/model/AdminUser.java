package com.nnbox.admin.data.model;

import java.util.List;

import com.nnbox.admin.api.authentication.model.AdminAuthMenuResponse;

import lombok.Data;

@Data
public class AdminUser {
    private Integer idx;

    private String id;

    private String password;

    private String email;

    private String phone;
    
    List<AdminAuthMenuResponse> adminAuth;
}