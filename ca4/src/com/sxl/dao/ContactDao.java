package com.sxl.dao;

import java.util.List;
import com.sxl.model.Contact;


public interface ContactDao {
	
	List<Contact> queryForList(Contact contact);

	int delete(Integer id);

	Contact getById(Integer id);

	int update(Contact contact);

	int insert(Contact contact);
}
