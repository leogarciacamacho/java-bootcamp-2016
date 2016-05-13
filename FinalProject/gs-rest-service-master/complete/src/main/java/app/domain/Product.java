package app.domain;

public class Product {
	private int productId;
	private String productName;
	public String category;
	private double price;
	
	public Product(int productId, String productName, String category, double price) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
	}
	
	public Product() {
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
