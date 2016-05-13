package app.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int cartId;
	private User user;
	private List<CartItem> items = new ArrayList<CartItem>();;
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

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
