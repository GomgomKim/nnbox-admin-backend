package com.nnbox.admin.data.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    private Integer idx;

	private String id;

	private String lastName;

	private String firstName;

	private String nationality;

	private String password;

	private String securityPassword;

	private String email;

	private Byte emailVerified;

	private String phone;

	private Byte phoneVerified;

	private Integer coin;

	private Integer point;

	private String otpKey;

	private String otpUrl;

	private Byte otpVerified;

	private String code;

	private String memo;

	private String recommender;

	private String token;

	private Date tokenDate;

	private String pushToken;

	private Byte pushFlag;

	private String signupDeviceId;

	private String loginType;

	private String loginLanguage;

	private Date loginDate;

	private Date createDate;

	private Byte deleted;

	private Date deleteDate;

	private Byte eventAgree;

	private String nickname;

	private String profileImage;

	private String appLanguage;

	private String translateLanguage;

}