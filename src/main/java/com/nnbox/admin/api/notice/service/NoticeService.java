package com.nnbox.admin.api.notice.service;

import java.util.List;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnbox.admin.api.notice.model.NoticeCreateRequest;
import com.nnbox.admin.api.notice.model.NoticeCreateResponse;
import com.nnbox.admin.api.notice.model.NoticeDeleteRequest;
import com.nnbox.admin.api.notice.model.NoticeDeleteResponse;
import com.nnbox.admin.api.notice.model.NoticeListRequest;
import com.nnbox.admin.api.notice.model.NoticeListResponse;
import com.nnbox.admin.api.notice.model.NoticeUpdateRequest;
import com.nnbox.admin.api.notice.model.NoticeUpdateResponse;
import com.nnbox.admin.data.mapper.NoticeMapper;
import com.nnbox.admin.data.model.Notice;

@Service
public class NoticeService {

	@Autowired
	NoticeMapper noticeMapper;

	public NoticeListResponse getNoticeList(NoticeListRequest listRequest) throws Exception {
		NoticeListResponse response = new NoticeListResponse();
		
		if (listRequest.getStartDate().equals("")) listRequest.setStartDate(null);
		if (listRequest.getEndDate().equals("")) listRequest.setEndDate(null);
		if (listRequest.getTitle().equals("")) listRequest.setTitle(null);
	    response.setCurrentPage(listRequest.getPageNum());
	    List<Notice> notices = noticeMapper.selectNoticeList(listRequest);
	    Integer totalCount = noticeMapper.getTotalCount(listRequest);

	    response.setNotices(notices);
	    response.setTotalCount(totalCount);
	    response.setTotalPage(totalCount, 10);

	    return response;
	}
	
	@Transactional
    public NoticeUpdateResponse updateNotice(NoticeUpdateRequest request) throws Exception {
		Notice notice = request;
		NoticeUpdateResponse result = noticeMapper.updateByPrimaryKeySelective(notice) > 0 ? NoticeUpdateResponse.SUCCESS : NoticeUpdateResponse.FAIL;
	    
	    return result;
    }
	
	public NoticeDeleteResponse deleteNotice(NoticeDeleteRequest request) throws Exception {
		NoticeDeleteResponse result = noticeMapper.deleteByPrimaryKey(request.getIdx()) > 0 ? NoticeDeleteResponse.SUCCESS : NoticeDeleteResponse.FAIL;
		
		return result;
	}
	
	public NoticeCreateResponse createNotice(NoticeCreateRequest request) throws Exception {
		Notice notice = request;
		
		NoticeCreateResponse result = noticeMapper.insertSelective(notice) > 0 ? NoticeCreateResponse.SUCCESS : NoticeCreateResponse.FAIL;
		
		return result;
	}
}
