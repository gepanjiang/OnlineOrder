package com.sxl.model;

/**
 * 订单列表
 * @author LiuFei
 *
 */
public class Orderlist {
	
	/**
	 * 订单列表主键
	 */
	private Integer id;

	/**
	 * 关联顾客id
	 */
	private Integer customerId;
	
	/**
	 * 关联订单id
	 */
	private Integer orderId;
	
	/**
	 * 关联商品id
	 */
	private Integer productId;

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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}