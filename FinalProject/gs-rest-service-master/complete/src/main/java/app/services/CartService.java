package app.services;

import java.sql.SQLException;
import java.util.List;

import app.domain.Cart;
import app.domain.Product;
import app.domain.User;

public interface CartService {
	
	Cart addNewCart(User user) throws SQLException, ClassNotFoundException;
	
	Cart getCart(int cartId) throws SQLException, ClassNotFoundException;
	
	void addToCart(int cartId, Product product, int quantity) throws SQLException, ClassNotFoundException;
	
	List<Cart> getCarts() throws SQLException, ClassNotFoundException;
	
	List<Cart> getCartsByUser (User user) throws SQLException, ClassNotFoundException;
	
	Cart buyProducts(Cart cart) throws SQLException, ClassNotFoundException;
}
