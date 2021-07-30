package com.nnbox.admin.api.settlement.service;

import java.util.List;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.settlement.model.NcashFeeListRequest;
import com.nnbox.admin.api.settlement.model.NcashFeeListResponse;
import com.nnbox.admin.data.mapper.CashLogMapper;
import com.nnbox.admin.data.mapper.LogMapper;
import com.nnbox.admin.data.mapper.UserMapper;
import com.nnbox.admin.data.mapper.WithdrawMapper;
import com.nnbox.admin.data.model.Ncash;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SettlementService {

	@Autowired
	LogMapper logMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	WithdrawMapper withdrawMapper;
	
	@Autowired
	CashLogMapper cashLogMapper;

	public NcashFeeListResponse getNcashFeeList(NcashFeeListRequest listRequest) throws Exception {
		NcashFeeListResponse response = new NcashFeeListResponse();
		
	    response.setCurrentPage(listRequest.getPageNum());
	    List<Ncash> ncashs = cashLogMapper.selectNcashFeeList(listRequest);
	    Integer totalCount = cashLogMapper.getNcashFeeTotalCount(listRequest);

	    response.setNcash(ncashs);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
}
