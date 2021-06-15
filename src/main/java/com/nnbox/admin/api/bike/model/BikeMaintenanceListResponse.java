package com.nnbox.admin.api.bike.model;

import java.util.List;

import com.nnbox.admin.common.model.ListResponse;
import com.nnbox.admin.data.model.BikeMaintenance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikeMaintenanceListResponse extends ListResponse {
	List<BikeMaintenance> bikeMaintenances;
}
