package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.rider.model.RiderListRequest;
import com.nnbox.admin.data.model.Rider;

@Mapper
public interface RiderMapper {
    int deleteByPrimaryKey(Integer userIdx);

    int insert(Rider record);

    int insertSelective(Rider record);

    Rider selectByPrimaryKey(Integer userIdx);

    int updateByPrimaryKeySelective(Rider record);

    int updateByPrimaryKey(Rider record);
    
    ///
    List<Rider> selectRiderList(RiderListRequest listRequest);
    
    int getTotalCount(RiderListRequest listRequest);
}