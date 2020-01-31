package com.sxl.model;

import java.util.Date;

/**
 * 库存信息表
 * @author LiuFei
 *
 */
public class Kc {
	
	/**
	 * 库存表id
	 */
	private Integer id;
	
	/**
	 * 关联商品id
	 */
	private Integer productId;
	
	/**
	 * 库存数量
	 */
	private Integer kcNum;
	
	/**
	 * 更新日期
	 */
	private Date insertDate;

	
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

	public Integer getKcNum() {
		return kcNum;
	}

	public void setKcNum(Integer kcNum) {
		this.kcNum = kcNum;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
}