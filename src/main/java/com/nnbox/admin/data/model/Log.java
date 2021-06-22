package com.nnbox.admin.data.model;

import java.time.LocalDateTime;

import com.nnbox.admin.common.constants.NyamnyamLogCategoryCode;

import lombok.Data;

@Data
public class Log {

	  // IDX
	  private Integer idx;

	  private LocalDateTime createDate;

	  // 카테고리
	  private NyamnyamLogCategoryCode category;

	  // 메모
	  private String memo;
	  
	  // 유저 그룹
	  private Integer userGroup;

	  // 유저(라이더, 가맹점) IDX
	  private Integer userIdx;

	  // user id
	  private String userId;

	  // 유형(1: 라이더, 2: 매장)
	  private Integer userType;

	  // 닉네임
	  private String nickname;

	  // 가맹점 IDX
	  private Integer frIdx;

	  // 이름(상호명)
	  private String frName;

	  // 지점 IDX
	  private Integer branchIdx;

	  // 내 상태(1: 근무, 2: 휴식, 3: 퇴근)
	  private Integer myStatus;

	  // 주문 IDX
	  private Integer orderIdx;

	  // 주문 시간
	  private LocalDateTime orderDate;

	  // 고객 요청 사항
	  private String custMessage;

	  // 고객 연락처
	  private String custPhone;

	  // 도착 요청 시간
	  private Integer arriveReqTime;

	  // 주문 금액
	  private Integer orderPrice;

	  // 운송료
	  private Integer deliveryPrice;

	  // 상태(1: 주문, 2: 라이더 배정, 3: 픽업 완료, 4: 배달 완료, 5: 주문 취소, 6: 기타)
	  private Integer orderStatus;

	  // 배달 주소(기본,신)
	  private String destAddr1;

	  // 배달 주소(상세)
	  private String destAddr2;

	  // 배달 주소(기본,구)
	  private String destAddr3;

	  // 취소 사유
	  private String cancelReason;

	  // 배정된 라이더 IDX
	  private Integer riderIdx;

	  // 결제 IDX
	  private Integer paymentIdx;

	  // 결제
	  private String payments;

	  // 결제 종류(1: 카드, 2: 현금, 3: 선결)
	  private String paymentMethod;

	  // 결제 금액
	  private String paymentAmount;

	  // 결제 상태(1: 요청, 2: 완료, 3: 취소, 4: 에러)
	  private String paymentStatus;

	  // 은행
	  private String bank;

	  // 계좌번호
	  private String bankAccount;

	  // 예금주
	  private String depositor;

	  // 요청 일자
	  private LocalDateTime withdrawReqDate;
	  
	  // 상태(1: 요청, 2: 처리 완료, 3: 취소)
	  private Integer withdrawStatus;

	  // 요청 금액
	  private Integer withdrawReqAmount;

	  // 처리 일자
	  private LocalDateTime procDate;

	  // 관리자 ID
	  private String adminId;

	  // 송금액
	  private Integer sendAmount;

	  // 받는 IDX
	  private Integer receiveIdx;

	  // 받는 ID
	  private String receiveId;

	  // 인센티브 카테고리
	  private Integer incenCategory;

	  // 인센티브 해당 월
	  private String incenMonth;

	  // 등급
	  private Integer userLevel;

	  // 지급된 인센티브
	  private Integer payedAmount;

	  // 가맹점 영업 IDX
	  private Integer frSalesIdx;

	  // 작업전 예치금
	  private Integer beforeNcash;

	  // 작업후 예치금
	  private Integer afterNcash;

	  // 작업(차감, 추가) 예치금
	  private Integer ncashDelta;

	  // 작업 카테고리(batch_work_ncash 테이블)
	  private Integer workCategory;

	  // batch_work_ncash 테이블의 IDX
	  private Integer batchIdx;

	  // 상품 IDX
	  private Integer productIdx;

	  // 상품명
	  private String name;

	  // 가격
	  private Integer price;

	  // 구매 상태(1: 결제 완료, 2: 수령 완료, 3: 환불 요청, 4: 환불 완료)
	  private Integer buyStatus;

	  // 방향
	  private Integer direction;

}