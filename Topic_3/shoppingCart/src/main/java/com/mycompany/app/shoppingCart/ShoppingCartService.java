package com.mycompany.app.shoppingCart;

import java.util.ArrayList;

/**
 * This interface manages the implementation of the shopping cart.
 * @author Leandro Garcia Camacho
 * @version 1.0
 * @since 2016-04-27
 */
public interface ShoppingCartService {
	
	/**
	 * Adds a product to the shopping list.
	 * @param id the ID of the product to buy
	 * @param quantity the amount of product to buy
	 */
	public void addToCart(int id, int quantity);
	
	/**
	 * Closes the shopping cart.
	 * @return the shopping list of products
	 */
	public ArrayList<Product> closeCart();
}
