package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.inquiry.model.InquiryListRequest;
import com.nnbox.admin.data.model.Inquiry;

@Mapper
public interface InquiryMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(Inquiry record);

    int insertSelective(Inquiry record);

    Inquiry selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(Inquiry record);

    int updateByPrimaryKey(Inquiry record);
    
    ///
    List<Inquiry> selectInquiryList(InquiryListRequest listRequest);
    
    int getTotalCount(InquiryListRequest listRequest);
    
    
}