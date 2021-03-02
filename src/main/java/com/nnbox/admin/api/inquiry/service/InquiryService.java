package com.nnbox.admin.api.inquiry.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.inquiry.model.InquiryListRequest;
import com.nnbox.admin.api.inquiry.model.InquiryListResponse;
import com.nnbox.admin.api.inquiry.model.InquiryModifyRequest;
import com.nnbox.admin.api.inquiry.model.InquiryModifyResult;
import com.nnbox.admin.common.utils.SessionUtil;
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
		
		List<String> categories = null;
		if (SessionUtil.getSessionUserToken().getUser().getId().equals("admin")) {
			categories = Arrays.asList(new String [] {"FRAN", "RIDE", "TAX", "LAW", "EXP"});
		}
		if (SessionUtil.getSessionUserToken().getUser().getId().equals("kimpo")) {
			categories = Arrays.asList(new String [] {"FRAN", "RIDE", "EXP"});
		}
		if (SessionUtil.getSessionUserToken().getUser().getId().equals("tax")) {
			categories = Arrays.asList(new String [] {"TAX"});
		}
		if (SessionUtil.getSessionUserToken().getUser().getId().equals("law")) {
			categories = Arrays.asList(new String [] {"LAW"});
		}

		List<Inquiry> list = inquiryMapper.selectList(listRequest, categories);
		response.setList(list);
		response.setTotalCount(inquiryMapper.selectListCount(listRequest, categories));
		response.setCurrentPage(listRequest.getPageNum());
		
		return response;
	}
	
	public InquiryModifyResult updateInquiry(InquiryModifyRequest request) throws Exception {
		return inquiryMapper.updateByPrimaryKeySelective(request.toModel()) > 0 ? InquiryModifyResult.SUCCESS : InquiryModifyResult.FAIL;
	}

}
