package com.sxl.dao;

import java.util.List;
import com.sxl.model.Types;


public interface TypesDao {
	
	List<Types> queryForList(Types types);

	int delete(Integer id);

	Types getById(Integer id);

	int update(Types types);

	int insert(Types types);
}
