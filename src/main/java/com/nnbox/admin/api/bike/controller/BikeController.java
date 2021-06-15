package com.nnbox.admin.api.bike.controller;

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

import com.nnbox.admin.api.bike.model.BikeMaintenanceListRequest;
import com.nnbox.admin.api.bike.model.BikeMaintenanceListResponse;
import com.nnbox.admin.api.bike.model.BikeMaintenanceUpdateRequest;
import com.nnbox.admin.api.bike.model.BikeMaintenanceUpdateResponse;
import com.nnbox.admin.api.bike.service.BikeService;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/bike")
@Api(value = "배달내역", tags = { "바이크" })
public class BikeController {
	@Autowired
	BikeService bikeService;
	
	@RequestMapping(value = "/maintenance/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "바이크 정비 이력 리스트", notes = "정비 이력을 불러온다.")
	public BikeMaintenanceListResponse getBikeMaintenanceList(@ModelAttribute BikeMaintenanceListRequest listRequest, BindingResult bindingResult) throws Exception {
		return bikeService.getBikeMaintenanceList(listRequest);
	}
	
	@RequestMapping(value = "/maintenance/update", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "바이크 정비 이력 수정", notes = "바이크 정비 이력 수정")
    public BikeMaintenanceUpdateResponse updateBikeMaintenance(@Valid @RequestBody BikeMaintenanceUpdateRequest request, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
		return bikeService.updateBikeMaintenance(request);
    }
	
	
	
}
