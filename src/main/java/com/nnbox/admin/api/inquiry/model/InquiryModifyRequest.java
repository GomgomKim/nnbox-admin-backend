package com.nnbox.admin.api.inquiry.model;

import com.nnbox.admin.data.model.Inquiry;

import lombok.Data;
import lombok.NonNull;

@Data
public class InquiryModifyRequest {
	private Integer idx;
	private String answer;
	private String memo;
	private String status;
	
	public Inquiry toModel() {
		Inquiry inquiry = new Inquiry();
		inquiry.setIdx(idx);
		inquiry.setAnswer(answer);
		inquiry.setMemo(memo);
		inquiry.setStatus(status);
		return inquiry;
	}
}
