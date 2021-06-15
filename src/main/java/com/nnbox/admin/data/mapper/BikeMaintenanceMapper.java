package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.bike.model.BikeMaintenanceListRequest;
import com.nnbox.admin.data.model.BikeMaintenance;

@Mapper
public interface BikeMaintenanceMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(BikeMaintenance record);

    int insertSelective(BikeMaintenance record);

    BikeMaintenance selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(BikeMaintenance record);

    int updateByPrimaryKey(BikeMaintenance record);
    
    //
    List<BikeMaintenance> selectBikeMaintenanceList(BikeMaintenanceListRequest request);
    
    int getTotalCount(BikeMaintenanceListRequest request);
}