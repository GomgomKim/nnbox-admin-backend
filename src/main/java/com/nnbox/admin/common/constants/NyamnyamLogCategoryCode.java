package com.nnbox.admin.common.constants;

import lombok.Getter;

@Getter
public enum NyamnyamLogCategoryCode {
  NONE("없음"),
  ORDER_CREATE("주문 생성"),
  RIDER_ASSIGN("라이더 배정"),
  RIDER_ASSIGN_CANCEL("라이더 배정 취소"),
  ORDER_PICKUP("픽업 완료"),
  ORDER_COMPLETE("배달 완료"),
  DELIVERY_PRICE_SEND("배송비 보내기"),
  DELIVERY_PRICE_RECEIVE("배송비 받기"),
  ORDER_CANCEL("주문 취소"),
  ORDER_UPDATE("주문 수정"),
  PAYMENT_COMPLETE("결제 완료"),
  PAYMENT_CHANGE("결제 변경"),
  PAYMENT_STATUS_CHANGE("결제 상태 변경"),
  ARRIVE_REQ_DATE_CHANGE("도착 요청 시간 변경"),
  NCASH_SEND("예치금 전송"),
  NCASH_SEND_BY_ADMIN("관리자 예치금 추가/차감"),
  WITHDRAW_REQ("출금 요청"),
  WITHDRAW_PROC("출금 처리"),
  NCASH_CHARGE_REQ("충전 요청"),
  NCASH_CHARGE_PROC("충전 처리"),
  DUES_PAY("가맹비 지급"),
  // 주로 출퇴근
  MY_STATUS_SET("내 상태 설정"),
  // 인센티브
  INCENTIVE_PAYED("인센티브 지급"),
  // 일차감(리스비, 대출)
  BATCH_WORK_NCASH("일차감"),
  // 몰 상품 구매
  BUY_PRODUCT("몰 상품 구매"),
  // 몰 상품 구매 취소
  BUY_PRODUCT_CANCEL("몰 상품 구매 취소"),
  // 라이더, 가맹점 차단
  RIDER_FR_BLOCK("라이더 <-> 가맹점 차단"),
  RIDER_FR_BLOCK_CANCEL("라이더 <-> 가맹점 차단 해제"),
  RIDER_FR_BLOCK_CANCEL_ALL("라이더 <-> 가맹점 차단 전부 해제");

  private final String category;

  private NyamnyamLogCategoryCode(String category) {
    this.category = category;
  }
}
