package com.nnbox.admin.api.inquiry.service;

import java.util.List;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnbox.admin.api.inquiry.model.InquiryListRequest;
import com.nnbox.admin.api.inquiry.model.InquiryListResponse;
import com.nnbox.admin.api.inquiry.model.InquiryUpdateRequest;
import com.nnbox.admin.api.inquiry.model.InquiryUpdateResponse;
import com.nnbox.admin.data.mapper.InquiryMapper;
import com.nnbox.admin.data.model.Inquiry;

@Service
public class InquiryService {

	@Autowired
	InquiryMapper inquiryMapper;

	public InquiryListResponse getInquiryList(InquiryListRequest listRequest) throws Exception {
		InquiryListResponse response = new InquiryListResponse();
		
	    response.setCurrentPage(listRequest.getPageNum());
	    List<Inquiry> inquirys = inquiryMapper.selectInquiryList(listRequest);
	    Integer totalCount = inquiryMapper.getTotalCount(listRequest);

	    response.setInquirys(inquirys);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	@Transactional
    public InquiryUpdateResponse completeInquiry(InquiryUpdateRequest request) throws Exception {
		Inquiry inquiry = request;
	    InquiryUpdateResponse result = inquiryMapper.updateByPrimaryKeySelective(inquiry) > 0 ? InquiryUpdateResponse.SUCCESS : InquiryUpdateResponse.FAIL;
	    return result;
    }
	
	
}
