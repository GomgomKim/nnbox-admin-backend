package com.nnbox.admin.data.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Order {

	private Integer idx;

  // 매장 IDX
	@ApiModelProperty(value = "매장 IDX", dataType = "Integer", example = "2", required = false, hidden = true)
  private Integer frIdx;

  // 생성 시간
  @ApiModelProperty(value = "생성 시간", dataType = "Timestamp", required = false, hidden = true)
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createDate;

	// 주문 시간
  @ApiModelProperty(value = "주문 시간. 미입력시 현재 시각", dataType = "Timestamp", required = false, hidden = true)
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime orderDate;

  // 고객 요청 사항
  private String custMessage;

  // 고객 연락처
  private String custPhone;

  // 도착 요청 시간
  @ApiModelProperty(value = "도착 요청 시간", dataType = "Integer", example = "10", required = true, hidden = false)
  private Integer arriveReqTime;

  // 상품 준비 시간(분)
  @ApiModelProperty(value = "상품 준비 시간(분). 이제는 사용하지 않는다.", dataType = "Integer", example = "10", required = false, hidden = true)
  private Integer itemPreparingTime;

  // 상품 준비 완료 여부
  private Boolean itemPrepared;

  // 주문 금액
  private Integer orderPrice;

  // 운송료
  private Integer deliveryPrice;

  // 운송료(기본)
  private Integer basicDeliveryPrice;

  // 운송료(할증)
  private Integer extraDeliveryPrice;

  // 상태(1: 주문, 2: 라이더 배정, 3: 픽업 완료, 4: 배달 완료, 5: 주문 취소, 6: 기타)
  private Integer orderStatus;

  // 배달 주소(기본, 신)
  private String destAddr1;

  // 배달 주소(상세)
  private String destAddr2;

  // 배달 주소(기본, 구)
  private String destAddr3;

  // 위도(배달지)
  private Double latitude;

  // 경도(배달지)
  private Double longitude;

  // 거리(가맹점 -> 배달지)
  private Integer distance;

  // 위도(가맹점)
  private Double frLatitude;

  // 경도(가맹점)
  private Double frLongitude;

  // 예치금 결제 허용 여부
  private Boolean ncashPayEnabled;

  // 취소 페널티 금액
  @ApiModelProperty(value = "취소 페널티 금액", dataType = "Integer", required = false, hidden = true)
  private Integer riderCancelPenaltyAmount;

  // 봉지 개수
  @ApiModelProperty(value = "봉지 개수", dataType = "Integer", required = true, hidden = false)
  private Integer packAmount;

  // 취소 사유
  private String cancelReason;

  // 메모
  private String memo;

  // 매장 ID
  private String frId;

  // 매장 이름(상호명)
  private String frName;

  // 매장 전화번호
  private String frPhone;

  // assign order
  // 주문 IDX
  private Integer orderIdx;

  // 배정된 라이더 IDX
  private Integer userIdx;

  // 배정된 라이더 이름
  private String riderName;

  // 배정된 라이더 전화번호
  private String riderPhone;

  // 배정 일자
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime assignDate;

  // 배달 수수료
  private Integer deliveryPriceFee;

  // 픽업 일자
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime pickupDate;

  // 완료 일자
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime completeDate;

  // tid(일반)
  private String tidNormal;

  // tid(선결제)
  private String tidPrepay;

  // 일반 지급 사용 비율
  private Integer tidNormalRate;

}
