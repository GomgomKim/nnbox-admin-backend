package com.nnbox.admin.api.rider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.rider.model.RiderListRequest;
import com.nnbox.admin.api.rider.model.RiderListResponse;
import com.nnbox.admin.data.mapper.RiderMapper;
import com.nnbox.admin.data.model.Rider;

@Service
public class RiderService {

	@Autowired
	RiderMapper riderMapper;
	
	public RiderListResponse getRiderList(RiderListRequest listRequest) throws Exception {
		RiderListResponse response = new RiderListResponse();

	    List<Rider> riders = riderMapper.selectRiderList(listRequest);
	    Integer totalCount = riderMapper.getTotalCount(listRequest);

	    response.setCurrentPage(listRequest.getPageNum());
	    response.setRiders(riders);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
}
