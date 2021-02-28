package com.nnbox.admin.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.exception.BasicException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClient {

	public static String executeGet(String url) throws Exception {
		RequestConfig requestConfig = RequestConfig.custom()
				  .setSocketTimeout(10*1000)
				  .setConnectTimeout(10*1000)
				  .setConnectionRequestTimeout(10*1000)
				  .build();
		HttpGet request = new HttpGet(url);
		request.setConfig(requestConfig);
		return execute(request);
	}
	
	public static String executePost(String url, HashMap<String, Object> params, boolean bjson) throws Exception {

		RequestConfig requestConfig = RequestConfig.custom()
				  .setSocketTimeout(10*1000)
				  .setConnectTimeout(10*1000)
				  .setConnectionRequestTimeout(10*1000)
				  .build();
		
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		
		if (bjson) {
			post.addHeader("content-type", "application/json");
			post.setEntity(new StringEntity(new Gson().toJson(params)));
		}
		else {
			List<NameValuePair> nvp = new ArrayList<NameValuePair>(); 
			for (Map.Entry<String, Object> entry: params.entrySet()) {
				nvp.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString())); 
			}
			post.setEntity(new UrlEncodedFormEntity(nvp));
		}
		
		return execute(post);
	}

	private static String execute(HttpUriRequest request) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		try {
			CloseableHttpResponse httpResponse = httpClient.execute(request);
			HttpStatus httpStatus = HttpStatus.valueOf(httpResponse.getStatusLine().getStatusCode());
			if (!httpStatus.is2xxSuccessful()) {
				throw new BasicException(ErrorCode.COMMON_HTTP_ERROR, 
						request.getMethod() + " " + request.getURI().toString() + " - " + httpStatus.getReasonPhrase());
			}
			return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		} catch (Exception e) {
			throw new BasicException(ErrorCode.COMMON_HTTP_ERROR, e.getMessage());
		} finally {
			httpClient.close();
		}
	}
}
