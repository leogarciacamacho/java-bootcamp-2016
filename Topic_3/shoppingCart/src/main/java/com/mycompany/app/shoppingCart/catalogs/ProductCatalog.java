package com.mycompany.app.shoppingCart.catalogs;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.app.shoppingCart.buisnessObject.Product;

public class ProductCatalog {
	private List<Product> products = new ArrayList<Product>();
	private static ProductCatalog instance = null;
	
	private ProductCatalog() {
	}
	
	public static ProductCatalog getInstance() {
		if(instance == null) {
			instance = new ProductCatalog();
		}
		return instance;
	}
	
	public Product get(int id) throws Exception {
		for(Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		throw new Exception();
	}
	
	public List<Product> getList() {
		return products;
	}
	
}
