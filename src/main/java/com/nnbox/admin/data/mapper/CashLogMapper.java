package com.nnbox.admin.data.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.data.model.CashLog;

@Mapper
public interface CashLogMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(CashLog record);

    int insertSelective(CashLog record);

    CashLog selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(CashLog record);

    int updateByPrimaryKey(CashLog record);
}