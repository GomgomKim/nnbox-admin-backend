package com.nnbox.admin.data.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Notice {
    private Integer idx;

    // 제목
    @ApiModelProperty(value = "제목", dataType = "String")
    private String title;

    // 내용
    @ApiModelProperty(value = "내용", dataType = "String")
    private String content;

    // 공지 생성 날짜
    @ApiModelProperty(value = "공지 생성 날짜", dataType = "LocalDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    // 삭제 여부
	private Byte deleted;
	
	// 삭제 일자
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deleteDate;

	// 카테고리(1: 전체, 2: 라이더, 3: 가맹점)
    @ApiModelProperty(value = "카테고리(1: 전체, 2: 라이더, 3: 가맹점)", dataType = "Integer")
    private Short category;

    // 정렬 순서
    @ApiModelProperty(value = "정렬 순서", dataType = "Integer", example = "100")
    private Integer sortOrder;

    // 중요 공지 여부
    @ApiModelProperty(value = "중요 공지 여부", dataType = "Integer", example = "0")
    private Byte important;

    // 지점 IDX(0: 전체)
    @ApiModelProperty(value = "지점 IDX(0: 전체)", dataType = "Integer", example = "0")
    private Integer branchIdx;
}