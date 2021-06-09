package com.nnbox.admin.api.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.delivery.model.RiderDeliveryListRequest;
import com.nnbox.admin.api.delivery.model.RiderDeliveryListResponse;
import com.nnbox.admin.api.delivery.service.DeliveryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/delivery")
@Api(value = "배달내역", tags = { "배달내역" })
public class DeliveryController {
	@Autowired
	DeliveryService deliveryService;


	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "배달내역 조회 전체", notes = "배달내역을 불러온다. 정직원, 라이더 배달내역은 특정 컬럼을 뽑아 사용하면 된다.", tags = { "배달내역" })
	public RiderDeliveryListResponse getDeliveryList(@ModelAttribute RiderDeliveryListRequest listRequest, BindingResult bindingResult) throws Exception {
		return deliveryService.getDeliveryList(listRequest);
	}
}
