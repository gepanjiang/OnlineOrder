package com.sxl.dao;

import java.util.List;
import com.sxl.model.Order;

public interface OrderDao {
	
	List<Order> queryForList(Order order);

	int delete(Integer id);

	Order getById(Integer id);

	int update(Order order);

	int insert(Order order);
}
