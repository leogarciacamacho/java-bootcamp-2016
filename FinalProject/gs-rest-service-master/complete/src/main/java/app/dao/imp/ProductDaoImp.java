package app.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.connector.DbConnector;
import app.dao.ProductDao;
import app.domain.Product;

@Repository
public class ProductDaoImp implements ProductDao {

	@Override
	@Transactional
	public Product getProduct(String productName) throws SQLException, ClassNotFoundException {
		Product product = new Product();
		String query = "SELECT * FROM products p where p.productName = ?";

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			preparedStatement.setString(1, productName);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				product.setProductId(result.getInt("productId"));
				product.setProductName(productName);
				product.setCategory(result.getString("category"));
				product.setPrice(result.getDouble("price"));
			}

		} catch (SQLException e) {
			throw e;
		}
		return product;
	}

	@Override
	@Transactional
	public List<Product> getProducts() throws SQLException, ClassNotFoundException {
		List<Product> products = new ArrayList<Product>();
		String query = "SELECT * FROM products";

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Product product = new Product();
				product.setProductId(result.getInt("productId"));
				product.setProductName(result.getString("productName"));
				product.setCategory(result.getString("category"));
				product.setPrice(result.getDouble("price"));
				products.add(product);
			}
		} catch (SQLException e) {
			throw e;
		}
		return products;
	}

	@Override
	@Transactional
	public List<Product> getProductsByCategory(String category) throws SQLException, ClassNotFoundException {
		List<Product> products = new ArrayList<Product>();
		String query = "SELECT * FROM products p WHERE p.category = ?";

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			preparedStatement.setString(1, category);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Product product = new Product();
				product.setProductId(result.getInt("productId"));
				product.setProductName(result.getString("productName"));
				product.setCategory(result.getString("category"));
				product.setPrice(result.getDouble("price"));
				products.add(product);
			}
		} catch (SQLException e) {
			throw e;
		}
		return products;
	}

}
