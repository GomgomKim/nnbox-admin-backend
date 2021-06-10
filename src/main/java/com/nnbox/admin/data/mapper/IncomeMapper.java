package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.delivery.model.RiderDeliveryListRequest;
import com.nnbox.admin.data.model.Income;

@Mapper
public interface IncomeMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(Income record);

    int insertSelective(Income record);

    Income selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(Income record);

    int updateByPrimaryKey(Income record);
    
    ///
    List<Income> selectRiderDeliveryList(RiderDeliveryListRequest request);
    
    int getTotalCount(RiderDeliveryListRequest request);
}