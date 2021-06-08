package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nnbox.admin.api.delivery.model.RiderDeliveryListRequest;
import com.nnbox.admin.api.delivery.model.StaffDeleveryListRequest;
import com.nnbox.admin.data.model.Order;

@Mapper
public interface OrderMapper {
	List<Order> selectRiderDeliveryList(RiderDeliveryListRequest listRequest);
	List<Order> selectOrderCompleteListByFrIdx(StaffDeleveryListRequest listRequest);
	int selectOrderCompleteListByFrIdxCnt(StaffDeleveryListRequest listRequest);
}
