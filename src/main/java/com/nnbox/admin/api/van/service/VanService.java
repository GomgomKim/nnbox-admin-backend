package com.nnbox.admin.api.van.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.van.model.VanListRequest;
import com.nnbox.admin.api.van.model.VanListResponse;
import com.nnbox.admin.data.mapper.VanMapper;
import com.nnbox.admin.data.model.Van;

@Service
public class VanService {

	@Autowired
	VanMapper vanMapper;
	
	public VanListResponse getVanList(VanListRequest listRequest) throws Exception {
		VanListResponse response = new VanListResponse();

	    List<Van> vans = vanMapper.selectVanList(listRequest);
	    Integer totalCount = vanMapper.getTotalCount(listRequest);

	    response.setCurrentPage(listRequest.getPageNum());
	    response.setVans(vans);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
}
