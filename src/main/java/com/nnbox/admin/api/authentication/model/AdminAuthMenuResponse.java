package com.nnbox.admin.api.authentication.model;

import java.util.List;

import com.nnbox.admin.data.model.Menu;

import lombok.Data;

@Data
public class AdminAuthMenuResponse {
	private Integer idx;
	
	private String name;
	
	private String nameKr;
	
	private String path;
	
	private Integer parentIdx;
	
	private Byte auth;
	
	private List<Menu> subMenu;
}
