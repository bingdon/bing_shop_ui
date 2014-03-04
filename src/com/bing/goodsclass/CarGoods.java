package com.bing.goodsclass;

/**
 *购物车商品信息类
 * @author lyl
 *
 */
public class CarGoods {
	//商品图片地址
	private String goodsurl;
	//商品信息
	private String goodsinfo;
	//商品标价
	private String goodstag;
	//左边状态
	private int LEFTTAG=0;
	//右边状态
	private int RIGHTTAG=0;
	
	private int activityname=0;
	public int getActivityname() {
		return activityname;
	}
	public void setActivityname(int activityname) {
		this.activityname = activityname;
	}
	public int getLEFTTAG() {
		return LEFTTAG;
	}
	public void setLEFTTAG(int lEFTTAG) {
		LEFTTAG = lEFTTAG;
	}
	public int getRIGHTTAG() {
		return RIGHTTAG;
	}
	public void setRIGHTTAG(int rIGHTTAG) {
		RIGHTTAG = rIGHTTAG;
	}
	public String getGoodsurl() {
		return goodsurl;
	}
	public void setGoodsurl(String goodsurl) {
		this.goodsurl = goodsurl;
	}
	public String getGoodsinfo() {
		return goodsinfo;
	}
	public void setGoodsinfo(String goodsinfo) {
		this.goodsinfo = goodsinfo;
	}
	public String getGoodstag() {
		return goodstag;
	}
	public void setGoodstag(String goodstag) {
		this.goodstag = goodstag;
	}
	
}
