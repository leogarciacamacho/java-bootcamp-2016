package com.mycompany.app.shoppingCart.stub;

import java.util.List;

import com.mycompany.app.shoppingCart.buisnessObject.Product;
import com.mycompany.app.shoppingCart.buisnessObject.User;
import com.mycompany.app.shoppingCart.catalogs.ProductCatalog;
import com.mycompany.app.shoppingCart.catalogs.StockCatalog;
import com.mycompany.app.shoppingCart.catalogs.UserCatalog;

public class DataBaseConnectorStub {
	private static DataBaseConnectorStub dataBaseStub = null;
	
	private DataBaseConnectorStub() {
	}
	
	public static DataBaseConnectorStub getInstance() {
		if(dataBaseStub == null) {
			dataBaseStub = new DataBaseConnectorStub();
		}
		return dataBaseStub;
	}
	
	public int addUser(User user) {
		return UserCatalog.getInstance().add(user);
	}
	
	public User getUser(int id) throws Exception {
		return UserCatalog.getInstance().get(id);
	}
	
	public void updateUser(User user) {
		UserCatalog.getInstance().update(user);
	}
	
	public void deleteUser(User user) {
		UserCatalog.getInstance().delete(user);
	}

	public List<User> getUsers() {
		return UserCatalog.getInstance().getList();
	}
	
	public Product getProduct(int id) throws Exception {
		return ProductCatalog.getInstance().get(id);
	}
	
	public int getProductAmount(Product product) throws Exception {
		return StockCatalog.getInstance().get(product);
	}
	
	public void setProductAmount(Product product, int quantity) throws Exception {
		StockCatalog.getInstance().set(product, quantity);
	}	
}
