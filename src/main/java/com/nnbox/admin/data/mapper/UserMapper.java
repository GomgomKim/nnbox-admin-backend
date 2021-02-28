package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.sample.model.UserListRequest;
import com.nnbox.admin.data.model.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer idx);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer idx);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectById(String id);

	List<User> selectList(UserListRequest listRequest);
}