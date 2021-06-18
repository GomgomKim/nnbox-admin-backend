package com.nnbox.admin.api.notice.model;

import java.util.List;

import com.nnbox.admin.common.model.ListResponse;
import com.nnbox.admin.data.model.Notice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeListResponse extends ListResponse {
	List<Notice> notices;
}
