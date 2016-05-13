package app.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.connector.DbConnector;
import app.dao.CartDao;
import app.domain.Cart;
import app.domain.CartItem;
import app.domain.Product;
import app.domain.User;

@Repository
public class CartDaoImp implements CartDao {

	@Override
	@Transactional
	public int getLastId() throws SQLException, ClassNotFoundException {
		String query = "SELECT MAX(c.cartId) maxId FROM carts c";
		ResultSet result;
		int cartId = 0;

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				cartId = result.getInt("maxId");
			}
		} catch (SQLException e) {
			throw e;
		}
		return cartId;
	}

	@Override
	@Transactional
	public void addCart(Cart cart) throws SQLException, ClassNotFoundException {
		int cartId = cart.getCartId();
		String userName = cart.getUser().getUserName();
		String query = "INSERT INTO carts VALUES (?, ?)";

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			preparedStatement.setString(2, userName);
			preparedStatement.execute();			
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public Cart getCart(int cartId) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM carts c INNER JOIN users u ON c.userName = u.userName WHERE c.cartId = ?";
		String query2 = "SELECT * FROM cartItems ci INNER JOIN products p ON ci.productId = p.productId WHERE ci.cartId = ?";
		ResultSet result;
		Cart cart = new Cart();

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				cart.setCartId(cartId);
				String userName = result.getString("userName");
				String pass = result.getString("pass");
				String email = result.getNString("email");
				cart.setUser(new User(userName, pass, email));
			}
			preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query2);
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

	@Override
	@Transactional //return true if the product was already in the item list
	public boolean addToCart(int cartId, Product product, int quantity) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM cartItems ci WHERE ci.cartId = ? AND ci.productId = ?";
		String query2 = "UPDATE cartItems SET quantity = ? WHERE cartId = ? AND productId = ? ";
		String query3 = "INSERT INTO cartItems VALUES (?, ?, ?)";
		ResultSet result;
		boolean flag = false;
		int productId = product.getProductId();
		int oldQuantity = 0;

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			preparedStatement.setInt(2, productId);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				oldQuantity = result.getInt("quantity");
				flag = true;
			}
			if (flag) {
				preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query2);
				preparedStatement.setInt(1, oldQuantity + quantity);
				preparedStatement.setInt(2, cartId);
				preparedStatement.setInt(3, productId);
				preparedStatement.execute();
			}	else {
				preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query3);
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

	@Override	
	@Transactional
	public List<Cart> getCartsByUser(User user) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM carts c WHERE c.userName = ?";
		String query2 = "SELECT * FROM cartItems ci INNER JOIN products p ON ci.productId = p.productId WHERE ci.cartId = ?";
		ResultSet result, result2;
		List<Cart> carts = new ArrayList<Cart>();
		String userName = user.getUserName();
		int cartId = 0;
		
		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			PreparedStatement preparedStatement2 = DbConnector.getInstance().getConnection().prepareStatement(query2);
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
	
	@Override
	@Transactional
	public List<Cart> getCarts() throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM carts c INNER JOIN users u ON c.userName = u.userName";
		String query2 = "SELECT * FROM cartItems ci INNER JOIN products p ON ci.productId = p.productId WHERE ci.cartId = ?";
		ResultSet result, result2;
		List<Cart> carts = new ArrayList<Cart>();
		int cartId = 0;
		
		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			PreparedStatement preparedStatement2 = DbConnector.getInstance().getConnection().prepareStatement(query2);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				cartId = result.getInt("cartId");
				preparedStatement2.setInt(1, cartId);
				result2 = preparedStatement2.executeQuery();
				String userName = result.getString("userName");
				String pass = result.getString("pass");
				String email = result.getString("email");
				Cart cart = new Cart(cartId, new User(userName, pass, email));
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
