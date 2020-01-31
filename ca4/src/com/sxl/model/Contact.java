package com.sxl.model;

import java.util.Date;


/**
 * 建议表
 * @author LiuFei
 *
 */
public class Contact {
	
	/**
	 * 建议表id
	 */
	private Integer id;

	/**
	 * 关联商家id
	 */
	private Integer customerId;
	
	/**
	 * 电话
	 */
	private String phone;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 日期
	 */
	private Date insertDate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
}