package com.nnbox.admin.data.model;

import lombok.Data;

@Data
public class Franchise {
	// 지점명s
	private String branchName;
	
	// 가맹점명
    private String frName;

    // 가맹점 주소
    private String addr1;

    private String addr2;

    private String addr3;

    // PG정보
    private Byte ncashPayEnabled;

    // PG사용비율
    private Short tidNormalRate;

    // 가맹점번호
    private String frPhone;

    // VAN
    private String vanNumber;
}
