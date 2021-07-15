package com.nnbox.admin.common.constants;

import lombok.Getter;

@Getter
public enum CashLogCategoryCode {
  NONE("없음"),
  DELIVERY_PRICE_SEND("배송비 보내기"),
  DELIVERY_PRICE_RECEIVE("배송비 받기"),
  NCASH_SEND("예치금 전송"),
  NCASH_SEND_BY_ADMIN("관리자 예치금 추가/차감"),
  WITHDRAW_REQ("출금 요청"),
  WITHDRAW_PROC("출금 처리"),
  NCASH_CHARGE_REQ("충전 요청"),
  NCASH_CHARGE_PROC("충전 처리"),
  DUES_PAY("가맹비 지급"),
  // 인센티브
  INCENTIVE_PAYED("인센티브 지급"),
  // 일차감(리스비, 대출)
  BATCH_WORK_NCASH("일차감");

  private final String category;

  private CashLogCategoryCode(String category) {
    this.category = category;
  }
}
