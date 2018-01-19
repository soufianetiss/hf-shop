package org.hf.util;

import java.util.Date;

import org.hf.entities.Shop;

public class ShopNearby {
	private Shop shop;
	private String myImpression;
	private Date dateImpression;
	public ShopNearby(Shop shop, String myImpression, Date dateImpression) {
		super();
		this.shop = shop;
		this.myImpression = myImpression;
		this.dateImpression = dateImpression;
	}
	public ShopNearby() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String getMyImpression() {
		return myImpression;
	}
	public void setMyImpression(String myImpression) {
		this.myImpression = myImpression;
	}
	public Date getDateImpression() {
		return dateImpression;
	}
	public void setDateImpression(Date dateImpression) {
		this.dateImpression = dateImpression;
	}
	@Override
	public String toString() {
		return "ShopNearby [shop=" + shop + ", myImpression=" + myImpression + ", dateImpression=" + dateImpression
				+ "]";
	}
	
	

}
