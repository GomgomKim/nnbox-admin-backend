package com.nnbox.admin.data.model;

import java.time.LocalDate;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {

  // IDX
  private Integer idx;

  @ApiModelProperty(value = "아이디", dataType = "String", example = "knowend")
  private String id;

  // 비밀번호
  @ApiModelProperty(value = "비밀번호", dataType = "String", example = "")
  private String password;

  private String securityPassword;

  // 이메일
  private String email;

  // 전화번호
  @ApiModelProperty(value = "전화번호", dataType = "String", example = "010-0000-0000")
  private String phone;

  // 냠냠캐쉬
  @ApiModelProperty(value = "냠냠캐쉬", dataType = "Integer", example = "0")
  private Integer ncash;

  @ApiModelProperty(value = "내 상태(1: 근무, 2: 휴식, 3: 퇴근)", dataType = "Integer", example = "3")
  private Integer userStatus;

  private String otpKey;

  private String otpUrl;

  private Boolean otpVerified;

  private String code;

  private String memo;

  private Integer recommenderIdx;

  private String token;

  private Date tokenDate;

  private String pushToken;

  private Boolean pushFlag;

  private String signupDeviceId;

  private String loginType;

  private String loginLanguage;

  private Date loginDate;

  private Date createDate;

  private Boolean deleted;

  private Date deleteDate;

  // 프로필 사진
  private String profileImage;

  // 유형(1: 라이더, 2: 매장)
  @ApiModelProperty(value = "유형(1: 라이더, 2: 매장)", dataType = "Integer", example = "1")
  private Integer userType;

  // 출금 한도(기본 10만원?)
  @ApiModelProperty(value = "출금 한도", dataType = "Integer", example = "100000")
  private Integer withdrawLimit;

  // 출금 비밀번호
  @ApiModelProperty(value = "출금 비밀번호", dataType = "String", example = "")
  private String withdrawPassword;

  // 출금 가능 여부
  @ApiModelProperty(value = "출금 가능 여부", dataType = "Boolean", example = "true")
  private boolean withdrawEnabled;

  // 은행
  @ApiModelProperty(value = "은행", dataType = "String", example = "한국은행")
  private String bank;

  // 계좌번호
  @ApiModelProperty(value = "계좌번호", dataType = "String", example = "111-111-1111")
  private String bankAccount;

  // 예금주
  @ApiModelProperty(value = "예금주", dataType = "String", example = "냠냠박스")
  private String depositor;

  // 소속 지점
  @ApiModelProperty(value = "소속 지점", dataType = "Integer", example = "1")
  private Integer branchIdx;

  // 문자 수신 동의
  private Boolean agreeSms;

  // rider
  // 라이더 이름
  private String riderName;

  private Integer riderStatus;

  // 등급(1: 라이더, 2: 부팀장, 3: 팀장, 4: 부본부장, 5: 본부장, 6: 부지점장, 7: 지점장, 8: 부센터장, 9: 센터장)
  @ApiModelProperty(value = "등급(1: 라이더, 2: 부팀장, 3: 팀장, 4: 부본부장, 5: 본부장, 6: 부지점장, 7: 지점장, 8: 부센터장, 9: 센터장)", dataType = "Integer", example = "1")
  private Integer riderLevel;

  // 배달비 수수료 유형(1: 정액, 2: 정률)
  @ApiModelProperty(value = "배달비 수수료 유형(1: 정액, 2: 정률)", dataType = "Integer", example = "1")
  private Integer deliveryPriceFeeType;

  // 배달비 수수료 금액
  @ApiModelProperty(value = "배달비 수수료 금액", dataType = "Integer", example = "500")
  private Integer deliveryPriceFeeAmount;

  // 기본 배달료
  private Integer basicDeliveryPrice;

  // 월 기본 건수
  private Integer monthBasicAmount;

  // 관리 인센 지급 여부
  private Boolean managementIncenShouldBePayed;

  // 가맹 인센 지급 여부
  private Boolean frIncenShouldBePayed;

  // 선지급 인센 지급 여부
  private Boolean prepaymentIncenShouldBePayed;

  // franchise
  // 이름(상호명)
  @ApiModelProperty(value = "이름(상호명)", dataType = "String", example = "냠냠식당")
  private String frName;

  private Integer frStatus;

  // 사업자번호
  @ApiModelProperty(value = "사업자번호", dataType = "String", example = "111-11-11111")
  private String businessNumber;

  // 주소(기본, 신)
  @ApiModelProperty(value = "주소(기본, 신))", dataType = "String", example = "서울시 강남구 선릉로 717")
  private String addr1;

  // 주소(상세)
  @ApiModelProperty(value = "주소(상세)", dataType = "String", example = "3층 블릭트")
  private String addr2;

  // 주소(기본, 구)
  @ApiModelProperty(value = "주소(기본, 구)", dataType = "String", example = "서울시 강남구 논현동 111-22")
  private String addr3;

  // 위도
  @ApiModelProperty(value = "주소 위도", dataType = "Double", example = "37.51884425976253")
  private Double latitude;

  // 경도
  @ApiModelProperty(value = "주소 경도", dataType = "Double", example = "127.04050585566475")
  private Double longitude;

  // 사업장 전화 번호
  @ApiModelProperty(value = "사업장 전화 번호", dataType = "String", example = "02-111-2222")
  private String frPhone;

  // 예치금 결제 허용 여부(가맹점)
  @ApiModelProperty(value = "예치금 결제 허용 여부(가맹점)", dataType = "Boolean", example = "true")
  private Boolean ncashPayEnabled;

  // tid(일반)
  @ApiModelProperty(value = "tid(일반)", dataType = "String", example = "1111")
  private String tidNormal;

  // tid(선지급)
  @ApiModelProperty(value = "tid(선지급)", dataType = "String", example = "2222")
  private String tidPrepay;

  // 일반 지급 사용 비율
  @ApiModelProperty(value = "일반 지급 사용 비율", dataType = "Integer", example = "50")
  private Integer tidNormalRate;

  // 관리비 자동 결제 사용 여부
  @ApiModelProperty(value = "관리비 자동 결제 사용 여부", dataType = "Boolean", example = "true")
  private Boolean duesAutoChargeEnabled;

  // 차감 일자(1~31, 99: 말일)
  @ApiModelProperty(value = "차감 일자(1~31, 99: 말일)", dataType = "Integer", example = "1")
  private Integer chargeDate;

  // 관리비
  @ApiModelProperty(value = "관리비", dataType = "Integer", example = "30000")
  private Integer dues;

  // 대표 생년월일
  @ApiModelProperty(value = "대표 생년월일", dataType = "Timestamp", example = "1999-01-03")
  private LocalDate birthday;

  // 법인번호
  @ApiModelProperty(value = "법인번호", dataType = "String", example = "111-222-333444")
  private String corporateNumber;

  // 선지급 은행
  @ApiModelProperty(value = "선지급 은행", dataType = "String", example = "냠냠은행")
  private String prepayBank;

  // 선지급 계좌 번호
  @ApiModelProperty(value = "선지급 계좌 번호", dataType = "String", example = "111-222-33334444")
  private String prepayAccount;

  // 선지급 계좌 소유주
  @ApiModelProperty(value = "선지급 계좌 소유주", dataType = "String", example = "냠냠박스")
  private String prepayDepositor;

  // 가상계좌 은행
  @ApiModelProperty(value = "가상계좌 은행", dataType = "String", example = "냠냠은행")
  private String vAccountBank;

  // 가상계좌 번호
  @ApiModelProperty(value = "가상계좌 번호", dataType = "String", example = "111-222-44445555")
  private String vAccountNumber;

  // 가상계좌 소유주
  @ApiModelProperty(value = "가상계좌 소유주", dataType = "String", example = "냠냠박스")
  private String vAccountDepositor;

  private LocalDate registDate;

  private Integer frSettingGroupIdx;

}
