package com.mycompany.shoppingCart.bo;

public class CartItem {
	private int cartId;
	private int productId;
	private int quantity;

	public CartItem(int cartId, int productId, int quantity) {
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public CartItem() {
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
