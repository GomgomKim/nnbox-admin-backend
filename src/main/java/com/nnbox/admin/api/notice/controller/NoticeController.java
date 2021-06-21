package com.nnbox.admin.api.notice.controller;

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

import com.nnbox.admin.api.notice.model.NoticeCreateRequest;
import com.nnbox.admin.api.notice.model.NoticeCreateResponse;
import com.nnbox.admin.api.notice.model.NoticeDeleteRequest;
import com.nnbox.admin.api.notice.model.NoticeDeleteResponse;
import com.nnbox.admin.api.notice.model.NoticeListRequest;
import com.nnbox.admin.api.notice.model.NoticeListResponse;
import com.nnbox.admin.api.notice.model.NoticeUpdateRequest;
import com.nnbox.admin.api.notice.model.NoticeUpdateResponse;
import com.nnbox.admin.api.notice.service.NoticeService;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/notice")
@Api(value = "공지사항", tags = { "홈페이지공지" })
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "공지사항 리스트", notes = "공지사항 리스트.")
	public NoticeListResponse getNoticeList(@ModelAttribute NoticeListRequest listRequest, BindingResult bindingResult) throws Exception {
		return noticeService.getNoticeList(listRequest);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "공지사항 수정", notes = "공지사항 수정")
    public NoticeUpdateResponse updateNotice(@Valid @RequestBody NoticeUpdateRequest request, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
		return noticeService.updateNotice(request);
    }
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "공지사항 삭제", notes = "공지사항 삭제")
    public NoticeDeleteResponse deleteNotice(@Valid @RequestBody NoticeDeleteRequest request, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
		return noticeService.deleteNotice(request);
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "공지사항 등록", notes = "공지사항 등록")
    public NoticeCreateResponse createNotice(@Valid @RequestBody NoticeCreateRequest request, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
		return noticeService.createNotice(request);
    }
	
	
	
	
	
}
