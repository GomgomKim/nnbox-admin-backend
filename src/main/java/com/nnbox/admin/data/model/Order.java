package com.nnbox.admin.data.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Order {

	private Integer idx;
	
	// 주문 시간
//	@ApiModelProperty(value = "주문 시간. 미입력시 현재 시각", dataType = "Timestamp", required = false, hidden = true)
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String orderDate;

	// 주문 금액
	private Integer orderPrice;

	// 운송료
	private Integer deliveryPrice;

	// 운송료(기본)
	private Integer basicDeliveryPrice;

	// 운송료(할증)
	private Integer extraDeliveryPrice;

	// 배달 주소(기본, 신)
	private String destAddr1;

	// 배달 주소(상세)
	private String destAddr2;

	// 배달 주소(기본, 구)
	private String destAddr3;

	// 매장 이름(상호명)
	private String frName;

	// 매장 전화번호
	private String frPhone;

	// assign order
	// 주문 IDX
	private Integer orderIdx;

	// 배정된 라이더 이름
	private String riderName;

	// 배정된 라이더 전화번호
	private String riderPhone;

	// 배달 수수료
	private Integer deliveryPriceFee;

	// 픽업 일자
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime pickupDate;

	// 완료 일자
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime completeDate;

	// 라이더 직급
	private Integer riderLevel;
	
	// 라이더 상태
	private Integer riderStatus;
	
	// 라이더 그룹
	private Integer riderGroup;
	
	// 수수료 방식
	private Integer feeType;
}
