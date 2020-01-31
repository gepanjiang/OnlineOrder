package com.sxl.dao;

import java.util.List;
import com.sxl.model.Product;


public interface ProductDao {
	
	List<Product> queryForList(Product product);

	int delete(Integer id);

	Product getById(Integer id);

	int update(Product product);

	int insert(Product product);
}
