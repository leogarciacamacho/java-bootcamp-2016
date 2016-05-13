package app.dao;

import java.sql.SQLException;
import java.util.List;

import app.domain.Cart;
import app.domain.Product;
import app.domain.User;

public interface CartDao {
	
	int getLastId() throws SQLException, ClassNotFoundException;
	
	void addCart(Cart cart)throws SQLException, ClassNotFoundException;

	Cart getCart(int cartId) throws SQLException, ClassNotFoundException;

	boolean addToCart(int cartId, Product product, int quantity) throws SQLException, ClassNotFoundException;
	
	List<Cart> getCarts() throws SQLException, ClassNotFoundException;

	List<Cart> getCartsByUser(User user) throws SQLException, ClassNotFoundException;	
}
