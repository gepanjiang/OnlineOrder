package com.sxl.model;

/**
 * 类别表【存放商品类别】
 * @author LiuFei
 *
 */
public class Types {
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 类别名称
	 */
	private String typesName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypesName() {
		return typesName;
	}

	public void setTypesName(String typesName) {
		this.typesName = typesName;
	}
}