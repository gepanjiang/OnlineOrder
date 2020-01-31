package com.sxl.dao;

import java.util.List;
import com.sxl.model.Shopcar;


public interface ShopcarDao {
	
	List<Shopcar> queryForList(Shopcar shopcar);

	int delete(Integer id);

	Shopcar getById(Integer id);

	int update(Shopcar shopcar);

	int insert(Shopcar shopcar);
}
