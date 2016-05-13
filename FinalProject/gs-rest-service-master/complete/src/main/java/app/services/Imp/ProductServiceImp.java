package app.services.Imp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.ProductDao;
import app.domain.Product;
import app.services.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getProduct(String productName) throws SQLException, ClassNotFoundException {
		return productDao.getProduct(productName);
	}

	@Override
	public List<Product> getProducts() throws SQLException, ClassNotFoundException {
		return productDao.getProducts();
	}

	@Override
	public List<Product> getProductsByCategory(String category) throws SQLException, ClassNotFoundException {
		return productDao.getProductsByCategory(category);
	}
	
}
