package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.ncash.model.NcashListRequest;
import com.nnbox.admin.data.model.Log;
import com.nnbox.admin.data.model.LogKey;

@Mapper
public interface LogMapper {
    int deleteByPrimaryKey(LogKey key);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(LogKey key);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
    
    ///
    List<Log> selectNcashList(NcashListRequest listRequest);
    
    int getTotalCount(NcashListRequest listRequest);
}