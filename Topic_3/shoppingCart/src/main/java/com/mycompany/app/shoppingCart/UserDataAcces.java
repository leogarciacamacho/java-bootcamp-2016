package com.mycompany.app.shoppingCart;

public interface UserDataAcces {
	public void add(User user);
	public User getUser(int id);
	public void update(User user);
	public void delete(User user);
}
