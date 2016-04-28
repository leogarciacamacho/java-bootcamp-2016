package com.mycompany.app.shoppingCart;

import java.util.ArrayList;

public interface ProductDataAcces {
	public ArrayList<Product> getAllProducts();
	public Product getProduct(int id); 
}
