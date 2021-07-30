package com.nnbox.admin.api.settlement.model;

import java.util.List;

import com.nnbox.admin.common.model.ListResponse;
import com.nnbox.admin.data.model.Ncash;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NcashFeeListResponse extends ListResponse {
	List<Ncash> ncash;
}
