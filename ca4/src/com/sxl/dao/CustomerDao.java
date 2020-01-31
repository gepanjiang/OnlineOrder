package com.sxl.dao;

import java.util.List;
import com.sxl.model.Customer;


public interface CustomerDao {
	
	List<Customer> queryForList(Customer customer);

	int delete(Integer id);

	Customer getById(Integer id);

	int update(Customer customer);

	int insert(Customer customer);
}
