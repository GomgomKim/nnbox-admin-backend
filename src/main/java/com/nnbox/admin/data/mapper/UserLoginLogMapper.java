package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.data.model.UserLoginLog;
import com.nnbox.admin.data.model.UserLoginLogWithUser;

@Mapper
public interface UserLoginLogMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(UserLoginLog record);

    int insertSelective(UserLoginLog record);

    UserLoginLog selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(UserLoginLog record);

    int updateByPrimaryKey(UserLoginLog record);

    List<UserLoginLogWithUser> selectByUserIdx(Integer userIdx);
    
}