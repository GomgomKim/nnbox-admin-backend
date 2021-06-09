package com.nnbox.admin.api.delivery.service;

import java.util.List;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.delivery.model.RiderDeliveryListRequest;
import com.nnbox.admin.api.delivery.model.RiderDeliveryListResponse;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;
import com.nnbox.admin.common.security.token.UserAuthenticationToken;
import com.nnbox.admin.common.utils.SessionUtil;
import com.nnbox.admin.data.mapper.OrderMapper;
import com.nnbox.admin.data.model.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeliveryService {

	@Autowired
	OrderMapper orderMapper;

	public RiderDeliveryListResponse getDeliveryList(RiderDeliveryListRequest listRequest) throws Exception {
		UserAuthenticationToken token = SessionUtil.getSessionUserToken();
		if (token == null) {
			throw new BasicException(ErrorCode.COMMON_UNAUTHORIZED);
		} else {
			RiderDeliveryListResponse response = new RiderDeliveryListResponse();

		    response.setCurrentPage(listRequest.getPageNum());
		    List<Order> orders = orderMapper.selectRiderDeliveryList(listRequest);

		    response.setOrders(orders);

		    return response;
		}
	}
 
}
