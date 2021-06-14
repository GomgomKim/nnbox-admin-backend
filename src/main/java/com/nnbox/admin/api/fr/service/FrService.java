package com.nnbox.admin.api.fr.service;

import java.util.List;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnbox.admin.api.fr.model.FrListRequest;
import com.nnbox.admin.api.fr.model.FrListResponse;
import com.nnbox.admin.api.fr.model.FrUpdateRequest;
import com.nnbox.admin.api.fr.model.FrUpdateResponse;
import com.nnbox.admin.data.mapper.FranchiseMapper;
import com.nnbox.admin.data.model.Franchise;

@Service
public class FrService {

	@Autowired
	FranchiseMapper franchiseMapper;
	
	public FrListResponse getFrList(FrListRequest listRequest) throws Exception {
		FrListResponse response = new FrListResponse();

	    List<Franchise> franchises = franchiseMapper.selectFrList(listRequest);
	    Integer totalCount = franchiseMapper.getTotalCount(listRequest);

	    response.setCurrentPage(listRequest.getPageNum());
	    response.setFranchises(franchises);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	@Transactional
    public FrUpdateResponse updateFr(FrUpdateRequest request) throws Exception {
		Franchise fr = request;
	    FrUpdateResponse result = franchiseMapper.updateByPrimaryKeySelective(fr) > 0 ? FrUpdateResponse.SUCCESS : FrUpdateResponse.FAIL;
	    
	    return result;
    }
}
