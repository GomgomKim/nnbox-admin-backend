package com.nnbox.admin.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nnbox.admin.api.authentication.model.AdminAuthMenuResponse;
import com.nnbox.admin.data.model.Menu;

@Mapper
public interface MenuMapper {
    int deleteByPrimaryKey(Integer idx);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer idx);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    ///
	List<Menu> getMenuParent();

	List<Menu> getMenuParentOutInfo();

	List<AdminAuthMenuResponse> getAdminAuthMenu(Integer idx);

	List<AdminAuthMenuResponse> getMenuSub(@Param("parentIdx") Integer parentIdx, @Param("idx") Integer idx);

	AdminAuthMenuResponse getMyInfo();

	List<AdminAuthMenuResponse> getAllAdminAuthMenu(Integer idx);

	List<AdminAuthMenuResponse> allSubMenu(Integer idx);
}