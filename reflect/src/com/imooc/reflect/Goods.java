package com.imooc.reflect;

public class Goods {
	public Goods() {
		
	}
	public Goods(int goodsId,int goodsPrice,String goodsName, String goodsDesc) {
		GoodsId = goodsId;
		GoodsName = goodsName;
		GoodsPrice = goodsPrice;
		GoodsDesc = goodsDesc;
	}

	@Override
	public String toString() {
		return "Goods [GoodsId=" + GoodsId + ", GoodsName=" + GoodsName + 
		", GoodsPrice=" + GoodsPrice + ", GoodsDesc="+ GoodsDesc + "]";
	}

	private int GoodsId;
	private String GoodsName;
	private int GoodsPrice;
	private String GoodsDesc;
	
	public void display() {
		System.out.println("Goods [GoodsId=" + GoodsId + ", GoodsName=" 
	+ GoodsName + ", GoodsPrice=" + GoodsPrice + ", GoodsDesc="
	+ GoodsDesc + "]");
	}

	public int getGoodsId() {
		return GoodsId;
	}

	public void setGoodsId(int goodsId) {
		GoodsId = goodsId;
	}

	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}

	public int getGoodsPrice() {
		return GoodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		GoodsPrice = goodsPrice;
	}

	public String getGoodsDesc() {
		return GoodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		GoodsDesc = goodsDesc;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
