package com.nnbox.admin.data.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.data.model.Bike;

@Mapper
public interface BikeMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(Bike record);

    int insertSelective(Bike record);

    Bike selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(Bike record);

    int updateByPrimaryKey(Bike record);
}