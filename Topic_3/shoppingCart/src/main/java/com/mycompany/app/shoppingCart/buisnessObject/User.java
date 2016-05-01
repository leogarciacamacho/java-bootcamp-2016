package com.mycompany.app.shoppingCart.buisnessObject;

public class User {
	private int id;
	private String userName;
	private String email;
	private String password;
	private ShoppingCart shoppingCart;
	
	public User(String userName, String email, String password) {
		this.userName= userName;
		this.email = email;
		this.password = password;
		this.shoppingCart = new ShoppingCart();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
