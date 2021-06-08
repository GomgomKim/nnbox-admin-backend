package com.nnbox.admin.common.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResponse {
	int currentPage;
	int totalCount;
	int currentCount;

	@Setter(AccessLevel.NONE)
	int totalPage;

	public void setTotalPage(int totalCount, int pageSize) {
		this.totalPage = totalCount / pageSize + ((totalCount % pageSize == 0) ? 0 : 1);
	}
}
