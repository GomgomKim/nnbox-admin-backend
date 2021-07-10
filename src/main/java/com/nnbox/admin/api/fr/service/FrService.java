package com.nnbox.admin.api.fr.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nnbox.admin.api.fr.model.FrListRequest;
import com.nnbox.admin.api.fr.model.FrListResponse;
import com.nnbox.admin.api.fr.model.FrUpdateRequest;
import com.nnbox.admin.api.fr.model.FrUpdateResponse;
import com.nnbox.admin.common.utils.HttpClient;
import com.nnbox.admin.data.mapper.FranchiseMapper;
import com.nnbox.admin.data.model.Franchise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FrService {

	private static final String PG_AUTHORIZATION = "pk_fdee-9c4bdf-5f9-fc26f";
	private static final String PG_CREATE_WALLET_URL = "https://svcwallet.mtouch.com/wapi/mcht";

	@Autowired
	FranchiseMapper franchiseMapper;
	
	public FrListResponse getFrList(FrListRequest listRequest) throws Exception {
		FrListResponse response = new FrListResponse();

	    List<Franchise> franchises = franchiseMapper.selectFrList(listRequest);
	    Integer totalCount = franchiseMapper.getTotalCount(listRequest);

	    response.setCurrentPage(listRequest.getPageNum());
	    response.setFranchises(franchises);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	@Transactional
    public FrUpdateResponse updateFr(FrUpdateRequest request) throws Exception {
		Franchise fr = request;
	    FrUpdateResponse result = franchiseMapper.updateByPrimaryKeySelective(fr) > 0 ? FrUpdateResponse.SUCCESS : FrUpdateResponse.FAIL;
	    
	    return result;
    }
	
    public boolean frRegistPg(Integer userIdx) throws Exception {
    	Franchise franchise = franchiseMapper.selectFrByUserIdx(userIdx);
    	log.debug("franchise=" + franchise);
    	
    	if (franchise == null) return false;

    	HashMap<String, Object> mcht = new HashMap<String, Object>();
    	mcht.put("userId", franchise.getUserId());
    	mcht.put("name", "냠냠-" + franchise.getFrName());
    	mcht.put("identity", franchise.getBusinessNumber());
    	mcht.put("ceo", franchise.getOwnerName());
    	mcht.put("industry", "숙박 및 음식점업");
    	mcht.put("category", "음식점업");
    	mcht.put("taxType", "비과세");
    	mcht.put("tel", franchise.getFrPhone());
    	mcht.put("phone", franchise.getUserPhone());
    	mcht.put("email", franchise.getUserEmail());
    	mcht.put("addr1", franchise.getAddr1());
    	mcht.put("addr2", franchise.getAddr2());
    	mcht.put("trackId", "TRK_" + new Date().getTime());
    	mcht.put("udf", "");
    	mcht.put("summary", "사업자등록");
    	
    	HashMap<String, Object> params = new HashMap<String, Object>();
    	params.put("mcht", mcht);
    	
    	log.debug(new Gson().toJson(params));
    	
    	try {
    		String response = HttpClient.executePost(PG_CREATE_WALLET_URL, params, true, PG_AUTHORIZATION);
//    		String response = "{  \"result\": {    \"resultCd\": \"0000\",    \"resultMsg\": \"등록완료\",    \"advanceMsg\": \"사업자 계정이 등록되었습니다.\",    \"create\": \"20190717172256\"  },  \"mcht\": {    \"walletId\": \"W156335177694f125d\",    \"userId\": \"mcht1\",    \"name\": \"가맹1\",    \"status\": \"사용\",    \"identity\": \"4198800046\",    \"ceo\": \"대표\",    \"industry\": \"서비스\",    \"category\": \"결제대행\",    \"taxType\": \"과세\",    \"tel\": \"02-1588-1838\",    \"phone\": \"010-1234-5678\",    \"email\": \"mtouch@mtouch.com\",    \"zip\": \"15834\",    \"addr1\": \"서울시 ADDR1\",    \"addr2\": \"내다 ADDR2\",    \"accntId\": \"A15633517763e5bf2a\",    \"vaccntId\": \"V156335177689f9430\",    \"balance\": 0,    \"accnt\": {      \"accntId\": \"A15633517763e5bf2a\",      \"walletId\": \"W156335177694f125d\",      \"userId\": \"mcht1\",      \"status\": \"사용\",      \"bankName\": \"우리은행\",      \"bankCd\": \"020\",      \"account\": \"1005902772439\",      \"beneficiary\": \"(주)광원\",      \"verify\": \"허가\",      \"accountVerify\": true,      \"trxId\": \"T15633517757e2c8e9\",      \"trackId\": \"TRK_190104092854\",      \"create\": \"20190717172256\"    },    \"vaccnt\": {      \"vaccntId\": \"V156335177689f9430\",      \"walletId\": \"W156335177694f125d\",      \"userId\": \"mcht1\",      \"status\": \"사용\",      \"bankName\": \"우리은행\",      \"bankCd\": \"020\",      \"account\": \"28087795218958\",      \"beneficiary\": \"가맹1\",      \"trxId\": \"T15633517757e2c8e9\",      \"trackId\": \"TRK_190104092854\",      \"create\": \"20190717172256\"    },    \"trxId\": \"T15633517757e2c8e9\",    \"trackId\": \"TRK_190104092854\",    \"udf\": \"UDF\",    \"summary\": \"사업자등록\",    \"create\": \"20190717172256\"  }}";
    		JsonObject obj = new JsonParser().parse(response).getAsJsonObject();
    		String resultCd = obj.get("result").getAsJsonObject().get("resultCd").getAsString();
    		log.debug(response);
    		if (!"0000".equals(resultCd)) return false;

    		String walletId = obj.get("mcht").getAsJsonObject().get("walletId").getAsString();
    		String bankName = obj.get("mcht").getAsJsonObject().get("vaccnt").getAsJsonObject().get("bankName").getAsString();
    		String bankCd = obj.get("mcht").getAsJsonObject().get("vaccnt").getAsJsonObject().get("bankCd").getAsString();
    		String account = obj.get("mcht").getAsJsonObject().get("vaccnt").getAsJsonObject().get("account").getAsString();
    		String beneficiary = obj.get("mcht").getAsJsonObject().get("vaccnt").getAsJsonObject().get("beneficiary").getAsString();

    		Franchise frUpdate = new Franchise();
    		frUpdate.setUserIdx(userIdx);
    		frUpdate.setWalletId(walletId);
    		frUpdate.setVAccountBank(bankName + "," + bankCd);
    		frUpdate.setVAccountNumber(account);
    		frUpdate.setVAccountDepositor(beneficiary);
    		
    		franchiseMapper.updateByPrimaryKeySelective(frUpdate);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
}
