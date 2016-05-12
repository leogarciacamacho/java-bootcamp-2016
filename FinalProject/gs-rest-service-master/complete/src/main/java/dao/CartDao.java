package dao;

import java.sql.SQLException;
import java.util.List;

import bo.Cart;
import bo.CartItem;
import bo.User;

public interface CartDao {
	
	public int getLastId() throws SQLException;
	
	public void addCart(Cart cart)throws SQLException;

	public Cart getCart(int cartId) throws SQLException;

	public boolean addToCart(Cart cart, CartItem item) throws SQLException;

	public List<Cart> getCartsByUser(User user) throws SQLException;
}
