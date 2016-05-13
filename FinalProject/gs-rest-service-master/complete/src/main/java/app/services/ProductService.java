package app.services;

import java.sql.SQLException;
import java.util.List;

import app.domain.Product;

public interface ProductService {
	
	Product getProduct(String productName) throws SQLException, ClassNotFoundException;

	List<Product> getProducts() throws SQLException, ClassNotFoundException;

	List<Product> getProductsByCategory(String category) throws SQLException, ClassNotFoundException;
}
