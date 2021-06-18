package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.notice.model.NoticeListRequest;
import com.nnbox.admin.data.model.Notice;

@Mapper
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    
    //
    List<Notice> selectNoticeList(NoticeListRequest listRequest);
    
    int getTotalCount(NoticeListRequest listRequest);
}