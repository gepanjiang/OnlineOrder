package com.sxl.model;

/**
 * 菜单【用户购买的商品信息】
 * @author LiuFei
 *
 */
public class Shopcar {
	
	/**
	 * 菜单表id
	 */
	private Integer id;
	
	/**
	 * 关联商品表id
	 */
	private Integer productId;
	
	/**
	 * 购买数量
	 */
	private Integer num;
	
	/**
	 * 关联顾客id
	 */
	private Integer customerId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}