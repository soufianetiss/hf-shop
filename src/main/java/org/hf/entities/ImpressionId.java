package org.hf.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class ImpressionId implements Serializable{
	@DBRef(lazy=true)
	private User user;
	@DBRef(lazy=false)
	private Shop shop;
	public ImpressionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImpressionId(User user, Shop shop) {
		super();
		this.user = user;
		this.shop = shop;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@Override
	public String toString() {
		return "ImpressionId [user=" + user + ", shop=" + shop+ "]";
	}
	
	

}
