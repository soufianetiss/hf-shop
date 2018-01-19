package org.hf.entities;

import java.io.Serializable;

import org.hf.util.Location;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="shops")
public class Shop implements Serializable{
	
	@Id	
	private String id;
	private String name;
	private String email;
	private String picture;
	private Location location;
	public Shop(String id, String name, String email, String picture, Location location) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.location = location;
	}
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(String name, String email, String picture, Location location) {
		super();
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", email=" + email + ", picture=" + picture + ", location="
				+ location + "]";
	}
	
	

	
	
	
}
