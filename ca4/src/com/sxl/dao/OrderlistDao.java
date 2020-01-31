package com.sxl.dao;

import java.util.List;
import com.sxl.model.Orderlist;


public interface OrderlistDao {
	
	List<Orderlist> queryForList(Orderlist orderlist);

	int delete(Integer id);

	Orderlist getById(Integer id);

	int update(Orderlist orderlist);

	int insert(Orderlist orderlist);
}
