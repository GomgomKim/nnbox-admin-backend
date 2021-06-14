package com.nnbox.admin.api.fr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.fr.model.FrListRequest;
import com.nnbox.admin.api.fr.model.FrListResponse;
import com.nnbox.admin.api.fr.service.FrService;

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

}
