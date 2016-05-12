package services.Imp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import services.CartService;
import bo.Cart;
import bo.CartItem;
import bo.User;
import dao.CartDao;
import dao.imp.CartDaoImp;

public class CartServiceImp implements CartService {

//	@Autowired
	CartDao cartDao = new CartDaoImp();

	public Cart addNewCart(User user) throws SQLException {
		int cartId = cartDao.getLastId();
		cartId++;
		Cart cart = new Cart(cartId, user);
		cartDao.addCart(cart);
		return cart;
	}

	public Cart getCart(int cartId) throws SQLException {
		return cartDao.getCart(cartId);
	}

	public void addToCart(Cart cart, CartItem item) throws SQLException {
		boolean flag = cartDao.addToCart(cart, item);
		if (flag) {
			for (CartItem cartItem : cart.getItems()) {
				if (cartItem.getProduct() == item.getProduct()) {
					cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
				}
			}
		} else {
			cart.getItems().add(item);
		}
	}

	public List<Cart> getCartsByUser(User user) throws SQLException {
		return cartDao.getCartsByUser(user);
	}

}
