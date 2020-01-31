package com.sxl.model;

/**
 * 商品表
 * @author LiuFei
 *
 */
public class Product {
	
	/**
	 * 商品id
	 */
	private Integer id;
	
	/**
	 * 商品名称
	 */
	private String productName;
	
	/**
	 * 图片1
	 */
	private String productPic1;
	
	/**
	 * 图片2
	 */
	private String productPic2;
	
	/**
	 * 图片3
	 */
	private String productPic3;
	
	/**
	 * 图片4
	 */
	private String productPic4;
	
	/**
	 * 价格
	 */
	private Integer price;
	
	/**
	 * 原价
	 */
	private Integer oldPrice;
	
	/**
	 * 描述
	 */
	private String content;
	
	/**
	 * 数量
	 */
	private Integer nums;
	
	/**
	 * 推荐星级
	 */
	private String tjxj;
	
	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 分类【关联类别表id】
	 */
	private Integer typesId;
	
	/**
	 * 积分
	 */
	private Integer jf;
	
	/**
	 * 关联商家id【t_user表】
	 */
	private Integer userId;
	
	
	private Integer bqId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPic1() {
		return productPic1;
	}

	public void setProductPic1(String productPic1) {
		this.productPic1 = productPic1;
	}

	public String getProductPic2() {
		return productPic2;
	}

	public void setProductPic2(String productPic2) {
		this.productPic2 = productPic2;
	}

	public String getProductPic3() {
		return productPic3;
	}

	public void setProductPic3(String productPic3) {
		this.productPic3 = productPic3;
	}

	public String getProductPic4() {
		return productPic4;
	}

	public void setProductPic4(String productPic4) {
		this.productPic4 = productPic4;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Integer oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public String getTjxj() {
		return tjxj;
	}

	public void setTjxj(String tjxj) {
		this.tjxj = tjxj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTypesId() {
		return typesId;
	}

	public void setTypesId(Integer typesId) {
		this.typesId = typesId;
	}

	public Integer getJf() {
		return jf;
	}

	public void setJf(Integer jf) {
		this.jf = jf;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBqId() {
		return bqId;
	}

	public void setBqId(Integer bqId) {
		this.bqId = bqId;
	}
}