package services;

import java.sql.SQLException;
import java.util.List;

import bo.Cart;
import bo.CartItem;
import bo.User;

public interface CartService {
	public Cart addNewCart(User user) throws SQLException;
	
	public Cart getCart(int cartId) throws SQLException;
	
	public void addToCart(Cart cart, CartItem item) throws SQLException;
	
	public List<Cart> getCartsByUser (User user) throws SQLException;
}
