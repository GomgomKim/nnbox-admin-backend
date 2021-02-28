package com.nnbox.admin.common.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PushService {
	
	@Value("${push.url}")
	private String pushUrl;
	
	@Value("${push.apikey}")
	private String pushApikey;
	
	public void push(String token, String title, String content, HashMap<String, String> data) throws Exception {

	    URL url = new URL(pushUrl);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setDoOutput(true);
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Content-Type", "application/json");
	    conn.setRequestProperty("Authorization", "key=" + pushApikey);

	    conn.setDoOutput(true);
//	    String input = "{\"notification\" : {\"title\" : \"" + title + "\", \"body\" : \"" + content + "\"}, \"to\":\"" + token + "\", \"data\": { \"custom_notification\": { \"body\": \"minwoo\", \"title\": \"kim\" } }}";
	    String input = "{\"notification\" : {\"title\" : \"" + title + "\", \"body\" : \"" + content + "\"}, \"to\":\"" + token + "\", \"data\": { \"custom_notification\":" + new JSONObject(data) + "} }";
	    
	    OutputStream os = conn.getOutputStream();
        
	    os.write(input.getBytes("UTF-8"));
	    os.flush();
	    os.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + input);
        System.out.println("Response Code : " + responseCode);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // print result
        System.out.println(response.toString());
	}
}
