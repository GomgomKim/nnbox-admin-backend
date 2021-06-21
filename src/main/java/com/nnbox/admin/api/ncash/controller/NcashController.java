package com.nnbox.admin.api.ncash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.ncash.service.NcashService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("/ncash")
@Api(value = "예치금 입출금", tags = { "홈페이지공지" })
public class NcashController {
	@Autowired
	NcashService ncashService;
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
//	@ApiOperation(value = "예치금 지급내역", notes = "유저별 예치금 지급 이력을 불러온다.")
//	public NcashListResponse getNcashList(@ModelAttribute NcashListRequest listRequest, BindingResult bindingResult) throws Exception {
//		return ncashService.getNcashList(listRequest);
//	}
//	
//	@RequestMapping(value = "/withdraw/list", method = RequestMethod.GET, produces = "application/json")
//	@ApiOperation(value = "예치금 출금내역", notes = "유저별 예치금 출금 이력을 불러온다.")
//	public NcashListResponse getNcashList(@ModelAttribute NcashListRequest listRequest, BindingResult bindingResult) throws Exception {
//		return ncashService.getNcashList(listRequest);
//	}
	
	
//	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
//    @ApiOperation(value = "예치금 입출금 등록", notes = "예치금 입출금 등록")
//    public NcashCreateResponse createNcash(@Valid @RequestBody NcashCreateRequest request, BindingResult bindingResult) throws Exception {
//		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
//		return ncashService.createNcash(request);
//    }
	
	
	
	
	
}
