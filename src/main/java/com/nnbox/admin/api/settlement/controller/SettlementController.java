package com.nnbox.admin.api.settlement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.settlement.model.NcashFeeListRequest;
import com.nnbox.admin.api.settlement.model.NcashFeeListResponse;
import com.nnbox.admin.api.settlement.service.SettlementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/settlement")
@Api(value = "정산", tags = { "정산" })
public class SettlementController {
	@Autowired
	SettlementService settlementService;
	
	@RequestMapping(value = "/ncash/fee/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "예치금 지급내역", notes = "유저별 예치금 지급 이력을 불러온다.")
	public NcashFeeListResponse getNcashFeeList(@ModelAttribute NcashFeeListRequest listRequest, BindingResult bindingResult) throws Exception {
		return settlementService.getNcashFeeList(listRequest);
	}
}
