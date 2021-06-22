package com.nnbox.admin.api.rider.model;

import java.util.List;

import com.nnbox.admin.common.model.ListResponse;
import com.nnbox.admin.data.model.Rider;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiderListResponse extends ListResponse {
	List<Rider> riders;
}
