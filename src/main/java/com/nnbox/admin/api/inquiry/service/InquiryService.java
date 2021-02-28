package com.nnbox.admin.api.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.inquiry.model.InquiryListRequest;
import com.nnbox.admin.api.inquiry.model.InquiryListResponse;
import com.nnbox.admin.api.inquiry.model.InquiryModifyRequest;
import com.nnbox.admin.api.inquiry.model.InquiryModifyResult;
import com.nnbox.admin.data.mapper.InquiryMapper;
import com.nnbox.admin.data.model.Inquiry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InquiryService {
	
	@Autowired
	InquiryMapper inquiryMapper;

	public InquiryListResponse getInquiryList(InquiryListRequest listRequest) throws Exception {

		InquiryListResponse response = new InquiryListResponse();
		
		List<Inquiry> list = inquiryMapper.selectList(listRequest);
		response.setList(list);
		response.setTotalCount(inquiryMapper.selectListCount(listRequest));
		response.setCurrentPage(listRequest.getPageNum());
		
		return response;
	}
	
	public InquiryModifyResult updateInquiry(InquiryModifyRequest request) throws Exception {
		return inquiryMapper.updateByPrimaryKeySelective(request.toModel()) > 0 ? InquiryModifyResult.SUCCESS : InquiryModifyResult.FAIL;
	}

}
