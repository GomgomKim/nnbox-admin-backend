package com.nnbox.admin.api.ncash.controller;

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

import com.nnbox.admin.api.ncash.model.NcashAllListRequest;
import com.nnbox.admin.api.ncash.model.NcashAllListResponse;
import com.nnbox.admin.api.ncash.model.NcashCreateRequest;
import com.nnbox.admin.api.ncash.model.NcashCreateResponse;
import com.nnbox.admin.api.ncash.model.NcashDailyListRequest;
import com.nnbox.admin.api.ncash.model.NcashDailyListResponse;
import com.nnbox.admin.api.ncash.model.NcashListRequest;
import com.nnbox.admin.api.ncash.model.NcashListResponse;
import com.nnbox.admin.api.ncash.model.WithdrawListRequest;
import com.nnbox.admin.api.ncash.model.WithdrawListResponse;
import com.nnbox.admin.api.ncash.service.NcashService;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;
import com.nnbox.admin.data.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/ncash")
@Api(value = "예치금", tags = { "예치금" })
public class NcashController {
	@Autowired
	NcashService ncashService;
	
	@RequestMapping(value = "/deposit/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "예치금 지급내역", notes = "유저별 예치금 지급 이력을 불러온다.")
	public NcashListResponse getNcashList(@ModelAttribute NcashListRequest listRequest, BindingResult bindingResult) throws Exception {
		return ncashService.getNcashList(listRequest);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "예치금 지급", notes = "예치금을 지급한다.")
    public NcashCreateResponse createNcash(@Valid @RequestBody NcashCreateRequest request, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
		return ncashService.createNcash(request);
    }
	 
	@RequestMapping(value = "/withdraw/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "예치금 출금내역", notes = "유저별 예치금 출금 이력을 불러온다.")
	public WithdrawListResponse getWithdrawList(@ModelAttribute WithdrawListRequest listRequest, BindingResult bindingResult) throws Exception {
		return ncashService.getWithdrawList(listRequest);
	}
	
	@RequestMapping(value = "/all/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "예치금 전체내역", notes = "예치금 전체 이력을 불러온다.")
	public NcashAllListResponse getAllList(@ModelAttribute NcashAllListRequest listRequest, BindingResult bindingResult) throws Exception {
		return ncashService.getAllList(listRequest);
	}
	
	@RequestMapping(value = "/connect9/balance", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Connect9 본사 잔액", notes = "Connect9 본사 잔액을 불러온다.")
	public int getConnect9Ncash() throws Exception {
		return ncashService.getConnect9Ncash();
	}
	
	@RequestMapping(value = "/connect9", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Connect9 본사 정보", notes = "Connect9 본사 정보를 불러온다.")
	public User getConnect9() throws Exception {
		return ncashService.getConnect9();
	}
	
	@RequestMapping(value = "/daily/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "일차감 내역", notes = "일차감 내역을 불러온다.")
	public NcashDailyListResponse getNcashDailyList(@ModelAttribute NcashDailyListRequest listRequest, BindingResult bindingResult) throws Exception {
		return ncashService.getNcashDailyList(listRequest);
	}
	
}
