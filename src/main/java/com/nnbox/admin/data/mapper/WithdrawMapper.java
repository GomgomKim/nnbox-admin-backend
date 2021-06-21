package com.nnbox.admin.data.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.data.model.Withdraw;

@Mapper
public interface WithdrawMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(Withdraw record);

    int insertSelective(Withdraw record);

    Withdraw selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(Withdraw record);

    int updateByPrimaryKey(Withdraw record);
}