package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.ncash.model.NcashAllListRequest;
import com.nnbox.admin.api.ncash.model.NcashDailyListRequest;
import com.nnbox.admin.api.ncash.model.NcashListRequest;
import com.nnbox.admin.api.ncash.model.WithdrawListRequest;
import com.nnbox.admin.api.settlement.model.NcashFeeListRequest;
import com.nnbox.admin.data.model.CashLog;
import com.nnbox.admin.data.model.Ncash;
import com.nnbox.admin.data.model.NcashDaily;
import com.nnbox.admin.data.model.Withdraw;

@Mapper
public interface CashLogMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(CashLog record);

    int insertSelective(CashLog record);

    CashLog selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(CashLog record);

    int updateByPrimaryKey(CashLog record);
    
    ///
    List<Ncash> selectNcashList(NcashAllListRequest request);
    
    int getNcashTotalCount(NcashAllListRequest request);
    
    List<Withdraw> selectWithdrawList(WithdrawListRequest request);
    
    int getWithdrawTotalCount(WithdrawListRequest request);
    
    List<Withdraw> selectPaymentList(NcashListRequest request);
    
    int getPaymentTotalCount(NcashListRequest request);
    
    List<NcashDaily> selectNcashDailyList(NcashDailyListRequest request);
    
    int getNcashDailyListTotalCount(NcashDailyListRequest request);
    
    List<Ncash> selectNcashFeeList(NcashFeeListRequest request);
    
    int getNcashFeeTotalCount(NcashFeeListRequest request);
}