package com.nnbox.admin.api.ncash.service;

import java.util.List;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnbox.admin.api.ncash.model.NcashAllListRequest;
import com.nnbox.admin.api.ncash.model.NcashAllListResponse;
import com.nnbox.admin.api.ncash.model.NcashCreateRequest;
import com.nnbox.admin.api.ncash.model.NcashCreateResponse;
import com.nnbox.admin.api.ncash.model.NcashListRequest;
import com.nnbox.admin.api.ncash.model.NcashListResponse;
import com.nnbox.admin.api.ncash.model.WithdrawListRequest;
import com.nnbox.admin.api.ncash.model.WithdrawListResponse;
import com.nnbox.admin.common.constants.CashLogCategoryCode;
import com.nnbox.admin.common.constants.ErrorCode;
import com.nnbox.admin.common.constants.NyamnyamLogCategoryCode;
import com.nnbox.admin.common.exception.BasicException;
import com.nnbox.admin.common.security.token.UserAuthenticationToken;
import com.nnbox.admin.common.utils.SessionUtil;
import com.nnbox.admin.data.mapper.CashLogMapper;
import com.nnbox.admin.data.mapper.LogMapper;
import com.nnbox.admin.data.mapper.UserMapper;
import com.nnbox.admin.data.mapper.WithdrawMapper;
import com.nnbox.admin.data.model.CashLog;
import com.nnbox.admin.data.model.Log;
import com.nnbox.admin.data.model.Ncash;
import com.nnbox.admin.data.model.User;
import com.nnbox.admin.data.model.Withdraw;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NcashService {

	@Autowired
	LogMapper logMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	WithdrawMapper withdrawMapper;
	
	@Autowired
	CashLogMapper cashLogMapper;

	public NcashListResponse getNcashList(NcashListRequest listRequest) throws Exception {
		NcashListResponse response = new NcashListResponse();
		
	    response.setCurrentPage(listRequest.getPageNum());
	    List<Withdraw> payments = cashLogMapper.selectPaymentList(listRequest);
	    Integer totalCount = cashLogMapper.getPaymentTotalCount(listRequest);

	    response.setPayments(payments);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	public NcashCreateResponse createNcash(NcashCreateRequest request) throws Exception {
		UserAuthenticationToken token = SessionUtil.getSessionUserToken();
		if(request.getUserId() != null) {
			User user = userMapper.selectById(request.getUserId());
			Integer userIdx = user.getIdx();
			request.setReceiveUserIdx(userIdx);
		}
		if (token == null) {
	      throw new BasicException(ErrorCode.COMMON_UNAUTHORIZED);
	    } else {
	    	Integer receiveUserIdx = request.getReceiveUserIdx();
	        Integer ncashAmount = request.getNcashAmount();
	        
	        NcashCreateResponse result = NcashCreateResponse.FAIL;
	        // 받는 유저 확인.
	        User checkUser = userMapper.selectByPrimaryKey(receiveUserIdx);
	        if (checkUser == null) {
	          result = NcashCreateResponse.RECEIVE_USER_NOT_EXISTS;
	        } else {
	          // 유저 잔액 증가
	          result = userMapper.sendNcashByAdmin(request) == 1 ? NcashCreateResponse.SUCCESS : NcashCreateResponse.FAIL;
	          // 본사 잔액 차감
	          // 잔액 체크
	          Integer connect9Ncash = getConnect9Ncash();
	          if (connect9Ncash < request.getNcashAmount()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
	          else result = userMapper.withdrawC9Ncash(request) == 1 ? NcashCreateResponse.SUCCESS : NcashCreateResponse.FAIL;
	        }
	        
	        // log 생성
	        UserLog(NyamnyamLogCategoryCode.NCASH_SEND_BY_ADMIN, token, request);
	        CashLog(CashLogCategoryCode.NCASH_SEND_BY_ADMIN, token, request);
	        
	        log.debug("send ncash => receiveUserIdx: " + receiveUserIdx + ", ncashAmount: " + ncashAmount + ", result: " + result);

	        log.info("send ncash: {}", request);
	        
	        return result;
	    }
	}
	
	public WithdrawListResponse getWithdrawList(WithdrawListRequest listRequest) throws Exception {
		WithdrawListResponse response = new WithdrawListResponse();
		
	    response.setCurrentPage(listRequest.getPageNum());
	    List<Withdraw> withdraws = cashLogMapper.selectWithdrawList(listRequest);
	    Integer totalCount = cashLogMapper.getWithdrawTotalCount(listRequest);

	    response.setWithdraws(withdraws);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	public NcashAllListResponse getAllList(NcashAllListRequest listRequest) throws Exception {
		NcashAllListResponse response = new NcashAllListResponse();
		
	    response.setCurrentPage(listRequest.getPageNum());
	    List<Ncash> ncash = cashLogMapper.selectNcashList(listRequest);
	    Integer totalCount = cashLogMapper.getNcashTotalCount(listRequest);

	    response.setNcash(ncash);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	public int getConnect9Ncash() throws Exception {
		int c9Ncash = -1;
		UserAuthenticationToken token = SessionUtil.getSessionUserToken();
		if (token == null) {
	      throw new BasicException(ErrorCode.COMMON_UNAUTHORIZED);
	    } else {
	    	c9Ncash = userMapper.getC9Ncash();
	    }
		if (c9Ncash == -1) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
	    return c9Ncash;
	}
	
	public User getConnect9() throws Exception {
		UserAuthenticationToken token = SessionUtil.getSessionUserToken();
		User connect9 = null;
		if (token == null) {
	      throw new BasicException(ErrorCode.COMMON_UNAUTHORIZED);
	    } else {
	    	connect9 = userMapper.getConnect9();
	    }
//		log.debug("connect9 : "+connect9);
		if (connect9 == null) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
	    return connect9;
	}
	
	
	private void UserLog(NyamnyamLogCategoryCode category, UserAuthenticationToken token, NcashCreateRequest request) {
	    try {
	      // 받은 유저
	      User user2 = userMapper.selectByPrimaryKey(request.getReceiveUserIdx());
	      Log nyamnyamLog2 = new Log();
	      nyamnyamLog2.setCategory(category);
	      nyamnyamLog2.setMemo(category.getCategory());
	      nyamnyamLog2.setUserIdx(user2.getIdx());
	      nyamnyamLog2.setUserId(user2.getId());
	      nyamnyamLog2.setUserType(user2.getUserType());
	      nyamnyamLog2.setFrName(user2.getFrName());
	      nyamnyamLog2.setBranchIdx(user2.getBranchIdx());
	      nyamnyamLog2.setSendAmount(request.getNcashAmount());
	      nyamnyamLog2.setReceiveIdx(request.getReceiveUserIdx());
	      Integer ncashDelta2 = request.getNcashAmount();
	      nyamnyamLog2.setBeforeNcash(user2.getNcash() - ncashDelta2);
	      nyamnyamLog2.setAfterNcash(user2.getNcash());
	      nyamnyamLog2.setNcashDelta(ncashDelta2);
	      nyamnyamLog2.setAdminId(token.getId());
	      nyamnyamLog2.setReceiveId(user2.getId());
	      
	      logMapper.insertSelective(nyamnyamLog2);
	    } catch (Exception ex) {
	      log.debug("nyamnyamLog error: {}", ex.getMessage());
	    }
    }
	
	private void CashLog(CashLogCategoryCode category, UserAuthenticationToken token, NcashCreateRequest request) {
	    try {
	      // 받은 유저
	      User user2 = userMapper.selectByPrimaryKey(request.getReceiveUserIdx());
	      CashLog cashLog = new CashLog();
	      cashLog.setCategory(category);
	      cashLog.setMemo(category.getCategory());
	      cashLog.setUserIdx(user2.getIdx());
	      cashLog.setUserId(user2.getId());
	      cashLog.setUserType(user2.getUserType());
	      cashLog.setBranchIdx(user2.getBranchIdx());
	      cashLog.setSendAmount(request.getNcashAmount());
	      cashLog.setReceiveIdx(request.getReceiveUserIdx());
	      Integer ncashDelta2 = request.getNcashAmount();
	      cashLog.setBeforeNcash(user2.getNcash() - ncashDelta2);
	      cashLog.setNcashDelta(ncashDelta2);
	      cashLog.setAfterNcash(user2.getNcash());
	      cashLog.setVAccountBank(user2.getVAccountBank());
	      cashLog.setVAccountDepositor(user2.getVAccountDepositor());
	      cashLog.setVAccountNumber(user2.getVAccountNumber());
	      cashLog.setAdminId(token.getId());
	      cashLog.setReceiveId(user2.getId());
	      
	      cashLogMapper.insertSelective(cashLog);
	    } catch (Exception ex) {
	      log.debug("nyamnyamLog error: {}", ex.getMessage());
	    }
    }
}
