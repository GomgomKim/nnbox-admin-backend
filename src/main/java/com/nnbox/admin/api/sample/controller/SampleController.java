package com.nnbox.admin.api.sample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nnbox.admin.api.sample.model.UserCreateRequest;
import com.nnbox.admin.api.sample.model.UserCreateResult;
import com.nnbox.admin.api.sample.model.UserListRequest;
import com.nnbox.admin.api.sample.model.UserListResponse;
import com.nnbox.admin.api.sample.service.SampleService;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;
import com.nnbox.admin.data.model.UserLoginLogWithUser;

@CrossOrigin
@RestController
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	SampleService sampleService;

	@RequestMapping(value = "/user/create", method = RequestMethod.POST, produces = "application/json")
	public UserCreateResult createUser(@Valid @RequestBody UserCreateRequest request, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
		
		return sampleService.createUser(request);
	}
	
	@RequestMapping(value = "/user/list", method = RequestMethod.GET, produces = "application/json")
	public UserListResponse getUserList(@ModelAttribute UserListRequest listRequest) throws Exception {		
		return sampleService.getUserList(listRequest);
	}

	
	@RequestMapping(value = "/login/log/{userIdx}", method = RequestMethod.GET, produces = "application/json")
	public List<UserLoginLogWithUser> getLoginLogList(@PathVariable("userIdx") Integer userIdx, @RequestParam("test") String test) throws Exception {		
		return sampleService.getLoginLogList(userIdx);
	}
}
