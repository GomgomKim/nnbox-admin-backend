package com.nnbox.admin.common.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SmsService {
	
	private static final String ALIGO_URL = "https://apis.aligo.in/send/";

	public static boolean send(String phone, String msg, String smsVendor, String smsKey, String smsSecret, String smsSender) throws Exception{

		if ("uplus".equals(smsVendor)) {
			return sendUplus(phone, msg, smsKey, smsSecret, smsSender);
		}
		else if ("aligo".equals(smsVendor)) {
			return sendAligo(phone, msg, smsKey, smsSecret, smsSender);
		}
		
		return false;
	}
	public static boolean sendUplus(String phone, String msg, String smsKey, String smsSecret, String smsSender) throws Exception{
//		log.debug("phone send ---- +" + phone + " ::: " + msg );
//		String api_key = smsKey;
//		String api_secret = smsSecret;
//		String algorithm = "1"; //  알고리즘 유형
//		
//		Message sender = new Message(api_key, api_secret, algorithm);
//
//		HashMap<String, String> params = new HashMap<String, String>();
//
//		params.put("to", phone.replaceAll("-", "")); // 수신번호
//		params.put("from", smsSender); // 발신번호
//		params.put("msg_type", "S");	//메시지종류(S,M,L)
//		params.put("msg", msg);
//		params.put("send_type", "S"); //발송형태(예약R,즉시S)
////		params.put("subid", "subid");	//서브아이디
////		params.put("subject", "제목테스트");	//제목
//
//		JSONObject obj = (JSONObject) sender.send(params);
//		
//		log.debug("send result ====== " + obj.toString());
		return true;
	}
	public static boolean sendAligo(String phone, String msg, String smsKey, String smsSecret, String smsSender) throws Exception{
//
//		HashMap<String, Object> params = new HashMap();
//		params.put("key", smsKey);
//		params.put("user_id", smsSecret);
//		params.put("sender", smsSender);
//		params.put("receiver", phone);
//		params.put("msg", new String(msg.getBytes("utf-8"), "euc-kr"));
//		
//		try {
//			String smsResult = HttpClient.executePost(ALIGO_URL, params, false);
//			log.debug(smsResult);
//		}
//		catch(Exception e) {
//			return false;
//		}
//			
		return true;
	}
	public static void result() throws Exception{
//		String api_key = "UP-1598853005-0159";
//		String api_secret = "ka31945";
//		String algorithm = "1"; //  알고리즘 유형
//		Message message = new Message(api_key, api_secret, algorithm);
//
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("limit", "100");
//
//		JSONObject json = (JSONObject) message.pop(params);
//
//		log.debug(json.toString());
	}

}
