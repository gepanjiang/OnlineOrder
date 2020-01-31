package com.sxl.dao;

import java.util.List;
import com.sxl.model.Bq;


public interface BqDao {
	
	List<Bq> queryForList(Bq bq);

	int delete(Integer id);

	Bq getById(Integer id);

	int update(Bq bq);

	int insert(Bq bq);
}
