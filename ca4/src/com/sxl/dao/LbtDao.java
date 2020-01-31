package com.sxl.dao;

import java.util.List;
import com.sxl.model.Lbt;


public interface LbtDao {
	
	List<Lbt> queryForList(Lbt lbt);

	int delete(Integer id);

	Lbt getById(Integer id);

	int update(Lbt lbt);

	int insert(Lbt lbt);
}
