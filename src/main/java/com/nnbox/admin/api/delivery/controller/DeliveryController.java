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
import com.nnbox.admin.api.delivery.model.StaffDeleveryListRequest;
import com.nnbox.admin.api.delivery.model.StaffDeliveryListResponse;
import com.nnbox.admin.api.delivery.service.DeliveryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/delivery")
@Api(value = "주문", tags = { "주문" })
public class DeliveryController {
	@Autowired
	DeliveryService deliveryService;


	@RequestMapping(value = "/rider/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "배달내역 조회(라이더)", notes = "배달내역(라이더)을 불러온다.", tags = { "배달내역", "라이더" })
	public RiderDeliveryListResponse getRiderDeliveryList(@ModelAttribute RiderDeliveryListRequest listRequest, BindingResult bindingResult) throws Exception {
		return deliveryService.getRiderDeliveryList(listRequest);
	}

	@RequestMapping(value = "/staff/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "배달내역 조회(직원)", notes = "배달내역(직원)을 불러온다.", tags = { "배달내역", "직원" })
	public StaffDeliveryListResponse getStaffDeliveryList(@ModelAttribute StaffDeleveryListRequest listRequest, BindingResult bindingResult) throws Exception {
		return deliveryService.getStaffDeliveryList(listRequest);
	}

}
