package com.sds;

public class Product {
	private int id;
	private String name;
	private String category_id;
	private int price;
	private int num;
	private int cuml;
	public Product() {
		super();
	}

	public Product(int id, String name, int price, int num) {
		super();
		this.id = id;
		this.name = name;
		this.category_id = category_id;
		this.price = price;
		this.num = num;
		this.cuml = cuml;
	}
	public Product(int id, String name, String category_id, int price, int num, int cuml) {
		super();
		this.id = id;
		this.name = name;
		this.category_id = category_id;
		this.price = price;
		this.num = num;
		this.cuml = cuml;
	}

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getCategory_id() {

		return category_id;

	}

	public void setCategory_id(String category_id) {

		this.category_id = category_id;

	}

	public int getPrice() {

		return price;

	}

	public void setPrice(int price) {

		this.price = price;

	}

	public int getNum() {

		return num;

	}

	public void setNum(int num) {

		this.num = num;

	}

	public int getCuml() {

		return cuml;

	}

	public void setCuml(int cuml) {

		this.cuml = cuml;

	}

	@Override

	public String toString() {

		return "Product [id=" + id + ", name=" + name + ", category_id=" + category_id + ", price=" + price + ", num="

				+ num + ", cuml=" + cuml + "]";

	}
}
