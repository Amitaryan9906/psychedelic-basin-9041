package com.BeanClasses;

import java.io.Serializable;
import java.util.Date;

public class Tender implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String type;
	private int price;
	private String desc;
	private Date deadline;
	private String location;
	public Tender(String id, String name, String type, int price, String desc, Date deadline, String location) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.desc = desc;
		this.deadline = deadline;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Tender [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", desc=" + desc
				+ ", deadline=" + deadline + ", location=" + location + "]";
	}
}
