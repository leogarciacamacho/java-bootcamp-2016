package app.domain;

import java.util.ArrayList;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Cart entity", description = "Complete info about the cart an it's items")
public class Cart {

	@ApiModelProperty(value = "The id of the cart")
	private int cartId;

	@ApiModelProperty(value = "The user of the cart")
	private User user;

	@ApiModelProperty(value = "The shopping list")
	private List<CartItem> items = new ArrayList<CartItem>();;

	@ApiModelProperty(value = "The total amount of the products to buy")
	private double totalAmount = 0;

	public Cart(int cartId, User user) {
		this.cartId = cartId;
		this.user = user;
	}

	public Cart() {
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void closeCart() {
		for(CartItem item : items) {
			totalAmount += item.getProduct().getPrice() * item.getQuantity();
		}
	}

}
