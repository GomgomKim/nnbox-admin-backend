package com.nnbox.admin.api.inquiry.model;

import java.util.List;

import com.nnbox.admin.common.model.ListResponse;
import com.nnbox.admin.data.model.Inquiry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InquiryListResponse extends ListResponse {
	List<Inquiry> inquirys;
}
