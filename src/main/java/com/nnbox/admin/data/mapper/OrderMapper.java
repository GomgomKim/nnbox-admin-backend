package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.delivery.model.OrderDeliveryListRequest;
import com.nnbox.admin.data.model.Order;

@Mapper
public interface OrderMapper {
	List<Order> selectDeliveryList(OrderDeliveryListRequest listRequest);
	int getTotalCount(OrderDeliveryListRequest listRequest);
}
