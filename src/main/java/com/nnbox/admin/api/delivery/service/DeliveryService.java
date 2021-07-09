package com.nnbox.admin.api.delivery.service;

import java.util.ArrayList;
import java.util.List;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.delivery.model.OrderDeliveryListRequest;
import com.nnbox.admin.api.delivery.model.OrderDeliveryListResponse;
import com.nnbox.admin.api.delivery.model.RiderDeliveryListRequest;
import com.nnbox.admin.api.delivery.model.RiderDeliveryListResponse;
import com.nnbox.admin.api.delivery.model.StaffDeliveryListRequest;
import com.nnbox.admin.api.delivery.model.StaffDeliveryListResponse;
import com.nnbox.admin.data.mapper.IncentiveMapper;
import com.nnbox.admin.data.mapper.IncomeMapper;
import com.nnbox.admin.data.mapper.OrderMapper;
import com.nnbox.admin.data.model.Incentive;
import com.nnbox.admin.data.model.Income;
import com.nnbox.admin.data.model.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeliveryService {

	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	IncomeMapper incomeMapper;
	
	@Autowired
	IncentiveMapper incentiveMapper;

	public OrderDeliveryListResponse getDeliveryList(OrderDeliveryListRequest listRequest) throws Exception {
		OrderDeliveryListResponse response = new OrderDeliveryListResponse();

	    response.setCurrentPage(listRequest.getPageNum());
	    List<Order> orders = orderMapper.selectDeliveryList(listRequest);
	    Integer totalCount = orderMapper.getTotalCount(listRequest);

	    response.setOrders(orders);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	public RiderDeliveryListResponse getRiderDeliveryList(RiderDeliveryListRequest listRequest) throws Exception {
		RiderDeliveryListResponse response = new RiderDeliveryListResponse();
		
	    response.setCurrentPage(listRequest.getPageNum());
	    List<Income> incomes = incomeMapper.selectRiderDeliveryList(listRequest);
	    Integer totalCount = incomeMapper.getTotalCount(listRequest);

	    response.setIncomes(incomes);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	public StaffDeliveryListResponse getStaffDeliveryList(StaffDeliveryListRequest listRequest) throws Exception {
		StaffDeliveryListResponse response = new StaffDeliveryListResponse();
		
	    response.setCurrentPage(listRequest.getPageNum());
	    List<Incentive> incentives = incentiveMapper.selectStaffDeliveryList(listRequest);
	    Integer totalCount = incentiveMapper.getTotalCount(listRequest);
//	    Integer totalCount = 0;
	    List<Incentive> resultIncentives = new ArrayList<>();
	    if(incentives.size() > 1) {
	    	Incentive temp = new Incentive();
		    int curUser = incentives.get(0).getUserIdx();
		    String curMonth = incentives.get(0).getIncenMonth();
		    temp = incentives.get(0);
		    int manageIncenAmount = 0;
		    int frIncenAmount = 0;
		    int additionalIncenAmount = 0;
		    for(Incentive incentive : incentives) {
		    	if(incentive.getUserIdx() != curUser || !incentive.getIncenMonth().equals(curMonth)) {
		    		temp.setManageIncenAmount(manageIncenAmount);
		    		temp.setFrIncenAmount(frIncenAmount);
		    		temp.setAdditionalIncenAmount(additionalIncenAmount);
		    		resultIncentives.add(temp);
//		    		totalCount++;
		    		temp = incentive;
		    		curUser = incentive.getUserIdx();
		    		
		    		curMonth = incentive.getIncenMonth();
		    		
		    		additionalIncenAmount = 0;
				    manageIncenAmount = 0;
				    frIncenAmount = 0;
		    	}

		    	if(incentive.getManageIncenAmount() != null) manageIncenAmount += incentive.getManageIncenAmount();
		    	if(incentive.getFrIncenAmount() != null) frIncenAmount += incentive.getFrIncenAmount();
		    	if(incentive.getManageIncenAmount() != null) additionalIncenAmount += incentive.getManageIncenAmount();
		    	
		    }
		    resultIncentives.add(temp);
		    log.debug(resultIncentives.toString());
		    totalCount++;
	    }
	    

	    response.setIncentives(incentives);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
}
