package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.fr.model.FrListRequest;
import com.nnbox.admin.data.model.Franchise;

@Mapper
public interface FranchiseMapper {
    int updateByPrimaryKeySelective(Franchise record);
    
    List<Franchise> selectFrList(FrListRequest request);
    
    int getTotalCount(FrListRequest request);
    
    Franchise selectFrByUserIdx(Integer userIdx);
    
    ///
    List<Franchise> selectFrCashList(FrListRequest request);
    
    int getFrCashCount(FrListRequest request);
    
    List<Franchise> selectFrChargeList(FrListRequest request);
    
    int getFrChargeCount(FrListRequest request);
    
    
}