package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.ncash.model.NcashAllListRequest;
import com.nnbox.admin.data.model.CashLog;
import com.nnbox.admin.data.model.Ncash;

@Mapper
public interface CashLogMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(CashLog record);

    int insertSelective(CashLog record);

    CashLog selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(CashLog record);

    int updateByPrimaryKey(CashLog record);
    
    ///
    List<Ncash> selectNcashList(NcashAllListRequest request);
    
    int getNcashTotalCount(NcashAllListRequest request);
}