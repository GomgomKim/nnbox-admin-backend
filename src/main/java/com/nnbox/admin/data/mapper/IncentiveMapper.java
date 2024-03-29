package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.delivery.model.StaffDeliveryListRequest;
import com.nnbox.admin.data.model.Incentive;

@Mapper
public interface IncentiveMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(Incentive record);

    int insertSelective(Incentive record);

    Incentive selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(Incentive record);

    int updateByPrimaryKey(Incentive record);
    
    ///
    List<Incentive> selectStaffDeliveryList(StaffDeliveryListRequest request);
    
    int getTotalCount(StaffDeliveryListRequest request);
}