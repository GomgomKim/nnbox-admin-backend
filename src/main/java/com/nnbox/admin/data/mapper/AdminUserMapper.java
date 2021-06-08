package com.nnbox.admin.data.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.data.model.AdminUser;

@Mapper
public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
    
    ////
    AdminUser selectById(String id);
}