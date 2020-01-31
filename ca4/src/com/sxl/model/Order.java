package com.sxl.model;

import java.util.Date;

/**
 * 订单表
 * @author LiuFei
 *
 */
public class Order {
	
	/**
	 * 订单表id
	 */
	private Integer id;
	
	/**
	 * 用户id
	 */
	private Integer customerId;
	
	/**
	 * 订单详细
	 */
	private String productDetail;
	
	/**
	 * 订单总价格
	 */
	private String allPrice;
	
	/**
	 * 订单状态
	 */
	private String status;
	
	/**
	 * 订单编号
	 */
	private String orderNum;
	
	/**
	 * 物流信息
	 */
	private String pl;
	
	/**
	 * 订单创建日期
	 */
	private Date insertDate;
	
	/**
	 * 关联商家id
	 */
	private Integer userId;
	
	/**
	 * 订单完成日期
	 */
	private String orderDate;

	
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

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(String allPrice) {
		this.allPrice = allPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
}