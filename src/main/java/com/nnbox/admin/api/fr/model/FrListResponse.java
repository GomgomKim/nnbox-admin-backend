package com.nnbox.admin.api.fr.model;

import java.util.List;

import com.nnbox.admin.common.model.ListResponse;
import com.nnbox.admin.data.model.Franchise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrListResponse extends ListResponse {
	List<Franchise> franchises;
}
