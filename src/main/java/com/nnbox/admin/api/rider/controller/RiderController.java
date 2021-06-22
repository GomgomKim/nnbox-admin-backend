package com.nnbox.admin.api.rider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.rider.model.RiderListRequest;
import com.nnbox.admin.api.rider.model.RiderListResponse;
import com.nnbox.admin.api.rider.service.RiderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/rider")
@Api(value = "라이더", tags = { "라이더" })
public class RiderController {
	@Autowired
	RiderService riderService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "라이더 목록 조회", notes = "라이더 목록을 불러온다.")
	public RiderListResponse getRiderList(@ModelAttribute RiderListRequest listRequest, BindingResult bindingResult) throws Exception {
		return riderService.getRiderList(listRequest);
	}

}
