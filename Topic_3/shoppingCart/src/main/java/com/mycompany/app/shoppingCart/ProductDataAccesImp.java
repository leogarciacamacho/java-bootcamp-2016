package com.mycompany.app.shoppingCart;

import java.util.ArrayList;

public class ProductDataAccesImp implements ProductDataAcces {

	public ArrayList<Product> getAllProducts() {
		return DataBaseStub.getListOfProducts();
	}

	public Product getProduct(int id) {
		for(Product product : DataBaseStub.getListOfProducts()) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}
}
