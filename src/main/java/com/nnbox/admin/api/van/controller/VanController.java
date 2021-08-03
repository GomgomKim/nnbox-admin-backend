package com.nnbox.admin.api.van.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.van.model.VanListRequest;
import com.nnbox.admin.api.van.model.VanListResponse;
import com.nnbox.admin.api.van.service.VanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/van")
@Api(value = "VAN", tags = { "VAN" })
public class VanController {
	@Autowired
	VanService vanService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "라이더 목록 조회", notes = "라이더 목록을 불러온다.")
	public VanListResponse getVanList(@ModelAttribute VanListRequest listRequest, BindingResult bindingResult) throws Exception {
		return vanService.getVanList(listRequest);
	}

}
