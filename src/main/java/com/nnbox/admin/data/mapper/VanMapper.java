package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.van.model.VanListRequest;
import com.nnbox.admin.data.model.Van;

@Mapper
public interface VanMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(Van record);

    int insertSelective(Van record);

    Van selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(Van record);

    int updateByPrimaryKey(Van record);
    
    ///
    List<Van> selectVanList(VanListRequest request);
    
    int getTotalCount(VanListRequest request);
}