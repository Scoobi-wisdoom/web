package vo;

public class Product {
	private String id;
	private String category_id;
	private String name;
	private int price;
	
	public Product() {
	}

	public Product(String id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product(String id, String category_id, String name, int price) {
		this.id = id;
		this.category_id = category_id;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
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
		return "Product [id=" + id + ", category_id=" + category_id + ", name=" + name + ", price=" + price + "]";
	}
	
}
