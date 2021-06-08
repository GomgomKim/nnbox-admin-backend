package com.nnbox.admin.api.delivery.model;

import java.util.List;

import com.nnbox.admin.common.model.ListResponse;
import com.nnbox.admin.data.model.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDeliveryListResponse extends ListResponse {
	List<Order> orders;
}
