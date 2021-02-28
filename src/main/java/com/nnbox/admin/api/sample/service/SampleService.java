package com.nnbox.admin.api.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnbox.admin.api.sample.model.UserCreateRequest;
import com.nnbox.admin.api.sample.model.UserCreateResult;
import com.nnbox.admin.api.sample.model.UserListRequest;
import com.nnbox.admin.api.sample.model.UserListResponse;
import com.nnbox.admin.common.utils.PasswordUtil;
import com.nnbox.admin.data.mapper.UserLoginLogMapper;
import com.nnbox.admin.data.mapper.UserMapper;
import com.nnbox.admin.data.model.User;
import com.nnbox.admin.data.model.UserLoginLogWithUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {
	
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserLoginLogMapper userLoginLogMapper;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Transactional
	public UserCreateResult createUser(UserCreateRequest request) throws Exception {
		if (request.getId() == null || "".equals(request.getId())) {
			return UserCreateResult.INVALID_ID;
		}
		if (request.getPassword() == null || "".equals(request.getPassword())) {
			return UserCreateResult.INVALID_PASSWORD;
		}
		if (userMapper.selectById(request.getId()) != null) {
			return UserCreateResult.ID_EXIST;
		}
		if (PasswordUtil.isStrong(request.getPassword())) {
			return UserCreateResult.INVALID_PASSWORD;
		}
		
		User user = new User();
		user.setId(request.getId());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		UserCreateResult result = userMapper.insertSelective(user) > 0 ? UserCreateResult.SUCCESS : UserCreateResult.FAIL;
		
		log.debug("insert key=" + user.getIdx());
		
		return result;
	}

	@CacheEvict(cacheNames="sample.user.list", allEntries=true)
	public void clearLogCache() throws Exception{
	}

	@CacheEvict(cacheNames = "sample.user.list", key = "#listRequest.getSearchId() + '/' + #listRequest.getPageNum() + '/' + #listRequest.getPageSize()")
	public void clearLogCache(UserListRequest listRequest) throws Exception {
	}

	@Cacheable(cacheNames = "sample.user.list", key = "#listRequest.getSearchId() + '/' + #listRequest.getPageNum() + '/' + #listRequest.getPageSize()")
	public UserListResponse getUserList(UserListRequest listRequest) throws Exception {

		UserListResponse response = new UserListResponse();
		
		if ("".equals(listRequest.getSearchId())) listRequest.setSearchId(null);
		
		response.setCurrentPage(listRequest.getPageNum());
		List<User> users = userMapper.selectList(listRequest);
		response.setUsers(users);
		
		return response;
	}

	public List<UserLoginLogWithUser> getLoginLogList(Integer userIdx) throws Exception {
		
		return userLoginLogMapper.selectByUserIdx(userIdx);
	}
}
