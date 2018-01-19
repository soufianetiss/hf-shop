package org.hf.entities;

import java.io.Serializable;
import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="impressions")
public class Impression implements Serializable{
	@Id
	private ImpressionId id;
	private String impression;
	private Date date;
	
	
	public Impression(ImpressionId id, String impression, Date date) {
		super();
		this.id = id;
		this.impression = impression;
		this.date = date;
	}
	
	public Impression() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImpressionId getId() {
		return id;
	}
	public void setId(ImpressionId id) {
		this.id = id;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Impression [id=" + id.toString() + ", impression=" + impression + ", date=" + date + "]";
	}
		
	
}
