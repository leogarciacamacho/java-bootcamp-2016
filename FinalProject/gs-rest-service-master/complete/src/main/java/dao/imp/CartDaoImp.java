package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import bo.Cart;
import bo.CartItem;
import bo.Product;
import bo.User;
import connector.DbConnector;
import dao.CartDao;

public class CartDaoImp implements CartDao {

	@Transactional
	public int getLastId() throws SQLException {
		Connection conn = DbConnector.getInstance().getConnection();
		String query = "SELECT MAX(c.cartId) maxId FROM carts c";
		ResultSet result;
		int cartId = 0;

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				cartId = result.getInt("maxId");
			}
		} catch (SQLException e) {
			throw e;
		}
		return cartId;
	}

	@Transactional
	public void addCart(Cart cart) throws SQLException {
		Connection conn = DbConnector.getInstance().getConnection();
		int cartId = cart.getCartId();
		String userName = cart.getUser().getUserName();
		String query = "INSERT INTO carts VALUES (?, ?)";
		// String query2 = "INSERT INTO cartItems VALUES (?, ?, ?)";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			preparedStatement.setString(2, userName);
			preparedStatement.execute();
			/*
			 for (CartItem item : cart.getItems()) { preparedStatement =
			 conn.prepareStatement(query2); preparedStatement.setInt(1,
			 cartId); preparedStatement.setInt(2,
			 item.getProduct().getProductId()); preparedStatement.setInt(3,
			 item.getQuantity()); preparedStatement.execute(); }
			 */
		} catch (SQLException e) {
			throw e;
		}
	}

	@Transactional
	public Cart getCart(int cartId) throws SQLException {
		Connection conn = DbConnector.getInstance().getConnection();
		String query = "SELECT * FROM carts c INNER JOIN users u ON c.userName = u.userName WHERE c.cartId = ?";
		String query2 = "SELECT * FROM cartItems ci INNER JOIN products p ON ci.productId = p.productId WHERE ci.cartId = ?";
		ResultSet result;
		Cart cart = new Cart();

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				cart.setCartId(cartId);
				String userName = result.getString("userName");
				String pass = result.getString("pass");
				String email = result.getNString("email");
				cart.setUser(new User(userName, pass, email));
			}
			preparedStatement = conn.prepareStatement(query2);
			preparedStatement.setInt(1, cartId);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				int productId = result.getInt("productId");
				String productName = result.getString("productName");
				String category = result.getString("category");
				double price = result.getDouble("price");
				Product product = new Product(productId, productName, category, price);
				int quantity = result.getInt("quantity");
				cart.getItems().add(new CartItem(product, quantity));
			}
		} catch (SQLException e) {
			throw e;
		}
		return cart;
	}

	@Transactional //return true if the product was already in the item list
	public boolean addToCart(Cart cart, CartItem item) throws SQLException {
		Connection conn = DbConnector.getInstance().getConnection();
		String query = "SELECT * FROM cartItems ci WHERE ci.cartId = ? AND ci.productId = ?";
		String query2 = "UPDATE cartItems SET quantity = ? WHERE cartId = ? AND productId = ? ";
		String query3 = "INSERT INTO cartItems VALUES (?, ?, ?)";
		ResultSet result;
		int cartId = cart.getCartId();
		int productId = item.getProduct().getProductId();
		int quantity = item.getQuantity();
		boolean flag = false;
		int oldQuantity = 0;

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			preparedStatement.setInt(2, productId);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				oldQuantity = result.getInt("quantity");
				flag = true;
			}
			if (flag) {
				preparedStatement = conn.prepareStatement(query2);
				preparedStatement.setInt(1, oldQuantity + quantity);
				preparedStatement.setInt(2, cartId);
				preparedStatement.setInt(3, productId);
				preparedStatement.execute();
			}	else {
				preparedStatement = conn.prepareStatement(query3);
				preparedStatement.setInt(1, cartId);
				preparedStatement.setInt(2, productId);
				preparedStatement.setInt(3, quantity);
				preparedStatement.execute();

			}
			
		} catch (SQLException e) {
			throw e;
		}
		return flag;
	}

	@Transactional
	public List<Cart> getCartsByUser(User user) throws SQLException {
		Connection conn = DbConnector.getInstance().getConnection();
		String query = "SELECT * FROM carts c WHERE c.userName = ?";
		String query2 = "SELECT * FROM cartItems ci INNER JOIN products p ON ci.productId = p.productId WHERE ci.cartId = ?";
		ResultSet result, result2;
		List<Cart> carts = new ArrayList<Cart>();
		String userName = user.getUserName();
		int cartId = 0;
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
			preparedStatement.setString(1, userName);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				cartId = result.getInt("cartId");
				preparedStatement2.setInt(1, cartId);
				result2 = preparedStatement2.executeQuery();
				Cart cart = new Cart(cartId, user);
				while (result2.next()) {
					int productId = result2.getInt("productId");
					String productName = result2.getString("productName");
					String category = result2.getString("category");
					double price = result2.getDouble("price");
					Product product = new Product(productId, productName, category, price);
					int quantity = result2.getInt("quantity");
					cart.getItems().add(new CartItem(product, quantity));					
				}
				carts.add(cart);
			}
		} catch (SQLException e) {
			throw e;
		}
		return carts;
	}

}
