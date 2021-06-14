package com.nnbox.admin.api.fr.controller;

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

import com.nnbox.admin.api.fr.model.FrListRequest;
import com.nnbox.admin.api.fr.model.FrListResponse;
import com.nnbox.admin.api.fr.model.FrUpdateRequest;
import com.nnbox.admin.api.fr.model.FrUpdateResponse;
import com.nnbox.admin.api.fr.service.FrService;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/fr")
@Api(value = "가맹점", tags = { "가맹점" })
public class FrController {
	@Autowired
	FrService frService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "가맹점 목록 조회", notes = "가맹점 목록을 불러온다.")
	public FrListResponse getFrList(@ModelAttribute FrListRequest listRequest, BindingResult bindingResult) throws Exception {
		return frService.getFrList(listRequest);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	  @ApiOperation(value = "가맹점 정보 수정", notes = "가맹점 정보 수정")
	  public FrUpdateResponse updateFr(@Valid @RequestBody FrUpdateRequest request, BindingResult bindingResult) throws Exception {
	    if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
	    return frService.updateFr(request);
	  }

}
