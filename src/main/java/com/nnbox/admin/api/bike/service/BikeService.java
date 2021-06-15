package com.nnbox.admin.api.bike.service;

import java.util.List;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnbox.admin.api.bike.model.BikeMaintenanceCreateRequest;
import com.nnbox.admin.api.bike.model.BikeMaintenanceCreateResponse;
import com.nnbox.admin.api.bike.model.BikeMaintenanceDeleteRequest;
import com.nnbox.admin.api.bike.model.BikeMaintenanceDeleteResponse;
import com.nnbox.admin.api.bike.model.BikeMaintenanceListRequest;
import com.nnbox.admin.api.bike.model.BikeMaintenanceListResponse;
import com.nnbox.admin.api.bike.model.BikeMaintenanceUpdateRequest;
import com.nnbox.admin.api.bike.model.BikeMaintenanceUpdateResponse;
import com.nnbox.admin.data.mapper.BikeMaintenanceMapper;
import com.nnbox.admin.data.model.BikeMaintenance;

@Service
public class BikeService {

	@Autowired
	BikeMaintenanceMapper bikeMaintenanceMapper;

	public BikeMaintenanceListResponse getBikeMaintenanceList(BikeMaintenanceListRequest listRequest) throws Exception {
		BikeMaintenanceListResponse response = new BikeMaintenanceListResponse();

	    response.setCurrentPage(listRequest.getPageNum());
	    List<BikeMaintenance> bikeMaintenances = bikeMaintenanceMapper.selectBikeMaintenanceList(listRequest);
	    Integer totalCount = bikeMaintenanceMapper.getTotalCount(listRequest);

	    response.setBikeMaintenances(bikeMaintenances);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	@Transactional
    public BikeMaintenanceUpdateResponse updateBikeMaintenance(BikeMaintenanceUpdateRequest request) throws Exception {
		BikeMaintenance bikeMaintenance = request;
		BikeMaintenanceUpdateResponse result = bikeMaintenanceMapper.updateByPrimaryKeySelective(bikeMaintenance) > 0 ? BikeMaintenanceUpdateResponse.SUCCESS : BikeMaintenanceUpdateResponse.FAIL;
	    
	    return result;
    }
	
	public BikeMaintenanceDeleteResponse deleteBikeMaintenance(BikeMaintenanceDeleteRequest request) throws Exception {
		BikeMaintenanceDeleteResponse result = bikeMaintenanceMapper.deleteByPrimaryKey(request.getIdx()) > 0 ? BikeMaintenanceDeleteResponse.SUCCESS : BikeMaintenanceDeleteResponse.FAIL;
		
		return result;
	}
	
	public BikeMaintenanceCreateResponse createBikeMaintenance(BikeMaintenanceCreateRequest request) throws Exception {
		BikeMaintenance bikeMaintenance = request;
		bikeMaintenance.setMileage(0);
		BikeMaintenanceCreateResponse result = bikeMaintenanceMapper.insertSelective(bikeMaintenance) > 0 ? BikeMaintenanceCreateResponse.SUCCESS : BikeMaintenanceCreateResponse.FAIL;
		
		return result;
	}
}
