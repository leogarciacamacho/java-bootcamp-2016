package app.domain;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Product entity", description = "Complete info about the product")
public class Product {

	@ApiModelProperty(value = "The id of the product")
	private int productId;

	@ApiModelProperty(value = "The name of the product")
	private String productName;

	@ApiModelProperty(value = "The category of the product")
	public String category;

	@ApiModelProperty(value = "The price of the product")
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
