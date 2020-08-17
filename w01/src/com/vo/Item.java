package com.vo;

import java.sql.Date;

public class Item {
	private String it;
	private String name;
	private int price;
	private Date regdate;
	public Item() {
	}
	public Item(String it, String name, int price) {
		this.it = it;
		this.name = name;
		this.price = price;
	}
	public String getIt() {
		return it;
	}
	public void setIt(String id) {
		this.it = it;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [it=" + it + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
