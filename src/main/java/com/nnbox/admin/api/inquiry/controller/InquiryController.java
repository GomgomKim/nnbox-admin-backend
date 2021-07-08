package com.nnbox.admin.api.inquiry.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.inquiry.model.InquiryListRequest;
import com.nnbox.admin.api.inquiry.model.InquiryListResponse;
import com.nnbox.admin.api.inquiry.model.InquiryUpdateRequest;
import com.nnbox.admin.api.inquiry.model.InquiryUpdateResponse;
import com.nnbox.admin.api.inquiry.service.InquiryService;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/inquiry")
@Api(value = "홈페이지문의", tags = { "홈페이지문의" })
public class InquiryController {
	@Autowired
	InquiryService inquiryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "문의 리스트", notes = "문의 리스트를 불러온다.")
	public InquiryListResponse getInquiryList(@ModelAttribute InquiryListRequest listRequest, BindingResult bindingResult) throws Exception {
		return inquiryService.getInquiryList(listRequest);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "문의 완료", notes = "문의 완료하기")
    public InquiryUpdateResponse completeInquiry(@Valid @RequestBody InquiryUpdateRequest request, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
		return inquiryService.completeInquiry(request);
    }
}
