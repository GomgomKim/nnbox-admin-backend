package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.ncash.model.WithdrawListRequest;
import com.nnbox.admin.data.model.Withdraw;

@Mapper
public interface WithdrawMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(Withdraw record);

    int insertSelective(Withdraw record);

    Withdraw selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(Withdraw record);

    int updateByPrimaryKey(Withdraw record);
    
    ///
    List<Withdraw> selectWithdrawList(WithdrawListRequest listRequest);
    
    int getTotalCount(WithdrawListRequest listRequest);
}