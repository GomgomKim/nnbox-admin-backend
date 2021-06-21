package com.nnbox.admin.data.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Inquiry {
	@ApiModelProperty(value = "IDX", dataType = "Integer", example = "1", required = false, hidden = true)
    private Integer idx;

	@ApiModelProperty(value = "카테고리", dataType = "String", example = "FRAN", required = true, hidden = false)
    private String category;

	@ApiModelProperty(value = "제목", dataType = "String", example = "문의 제목", required = true, hidden = false)
    private String title;

	@ApiModelProperty(value = "내용", dataType = "String", example = "문의 내용", required = true, hidden = false)
    private String content;

	@ApiModelProperty(value = "답변", dataType = "String", example = "문의 답변", required = false, hidden = false)
    private String answer;

	@ApiModelProperty(value = "회사", dataType = "String", example = "company", required = false, hidden = false)
    private String company;

	@ApiModelProperty(value = "닉네임", dataType = "String", example = "nickname", required = true, hidden = false)
    private String name;

	@ApiModelProperty(value = "이메일", dataType = "String", example = "example@naver.com", required = false, hidden = false)
    private String email;

	@ApiModelProperty(value = "휴대전화 번호", dataType = "String", example = "01012345678", required = false, hidden = false)
    private String phone;

	@ApiModelProperty(value = "문의 상태(NEW, COMPELETE)", dataType = "String", example = "NEW", required = false, hidden = false)
    private String status;

	@ApiModelProperty(value = "관리자 메모", dataType = "String", example = "특이사항 메모", required = false, hidden = false)
    private String memo;

	@ApiModelProperty(value = "생성 일자", dataType = "LocalDateTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")  
    private LocalDateTime createDate;

	@ApiModelProperty(value = "수정 일자", dataType = "LocalDateTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;
}