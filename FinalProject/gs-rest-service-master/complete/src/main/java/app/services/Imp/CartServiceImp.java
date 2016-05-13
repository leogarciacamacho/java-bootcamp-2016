package app.services.Imp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.CartDao;
import app.domain.Cart;
import app.domain.CartItem;
import app.domain.Product;
import app.domain.User;
import app.services.CartService;

@Service
public class CartServiceImp implements CartService {

	@Autowired
	private CartDao cartDao;

	@Override
	public Cart addNewCart(User user) throws SQLException, ClassNotFoundException {
		int cartId = cartDao.getLastId();
		cartId++;
		Cart cart = new Cart(cartId, user);
		cartDao.addCart(cart);
		return cart;
	}

	@Override
	public Cart getCart(int cartId) throws SQLException, ClassNotFoundException {
		return cartDao.getCart(cartId);
	}

	@Override
	public void addToCart(int cartId, Product product, int quantity) throws SQLException, ClassNotFoundException {
		cartDao.addToCart(cartId, product, quantity);		
	}

	@Override
	public List<Cart> getCartsByUser(User user) throws SQLException, ClassNotFoundException {
		return cartDao.getCartsByUser(user);
	}

	@Override
	public Cart buyProducts(Cart cart) throws SQLException, ClassNotFoundException {
		double totalAmount = 0;
		for(CartItem item : cart.getItems()) {
			totalAmount += item.getProduct().getPrice() * item.getQuantity();
		}
		cart.setTotalAmount(totalAmount);
		return cart;
	}

	@Override
	public List<Cart> getCarts() throws SQLException, ClassNotFoundException {
		return cartDao.getCarts();
	}

}
