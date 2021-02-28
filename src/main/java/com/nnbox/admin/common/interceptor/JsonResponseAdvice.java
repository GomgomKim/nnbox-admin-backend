package com.nnbox.admin.common.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.google.gson.Gson;
import com.nnbox.admin.common.exception.BasicException;
import com.nnbox.admin.common.model.ResponseMsg;
import com.nnbox.admin.common.model.ResponseResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(basePackages = { "com.nnbox.admin.api", "com.nnbox.admin.common.exception" })
public class JsonResponseAdvice implements ResponseBodyAdvice<Object> {

	@Value("${logging.responseLength}")
	private Integer loggingResponseLength;
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {

		log.info("beforeBodyWrite - " + request.getURI());
		String responseString = new Gson().toJson(body);
		if (responseString.length() > loggingResponseLength) responseString = responseString.substring(0, loggingResponseLength);
		log.info(responseString);

		ResponseMsg msg = new ResponseMsg();
		if (body instanceof BasicException)
			msg.setResult(ResponseResult.FAIL);
		else
			msg.setResult(ResponseResult.SUCCESS);
		msg.setData(body);

		return msg;
	}
}
