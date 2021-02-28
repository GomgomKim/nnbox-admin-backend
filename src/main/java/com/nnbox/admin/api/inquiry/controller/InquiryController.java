package com.nnbox.admin.api.inquiry.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.inquiry.model.InquiryListRequest;
import com.nnbox.admin.api.inquiry.model.InquiryListResponse;
import com.nnbox.admin.api.inquiry.model.InquiryModifyRequest;
import com.nnbox.admin.api.inquiry.model.InquiryModifyResult;
import com.nnbox.admin.api.inquiry.service.InquiryService;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;

@CrossOrigin
@RestController
@RequestMapping("/inquiry")
public class InquiryController {

	@Autowired
	InquiryService inquiryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public InquiryListResponse getInquiryList(@ModelAttribute InquiryListRequest listRequest) throws Exception {		
		return inquiryService.getInquiryList(listRequest);
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = "application/json")
	public InquiryModifyResult updateInquiry(@Valid @RequestBody InquiryModifyRequest request, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
		
		return inquiryService.updateInquiry(request);
	}
	
	
}
