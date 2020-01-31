package com.sxl.dao;

import java.util.List;
import com.sxl.model.Pinglun;


public interface PinglunDao {
	
	List<Pinglun> queryForList(Pinglun pinglun);

	int delete(Integer id);

	Pinglun getById(Integer id);

	int update(Pinglun pinglun);

	int insert(Pinglun pinglun);
}
