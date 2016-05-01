package com.mycompany.app.shoppingCart.Services;

import java.util.List;

import com.mycompany.app.shoppingCart.buisnessObject.ProductAmount;

/**
 * This interface manages the implementation of the shopping cart.
 * @author Leandro Garcia Camacho
 * @version 1.0
 * @since 2016-04-27
 */
public interface ShoppingCartService {
	
	/**
	 * Sets the current user of the shopping cart.
	 * @param userName
	 * @param password
	 */
	public void logIn(String userName, String password);
	
	/**
	 * Logs out the current user. 
	 */
	public void logOut();
	
	/**
	 * Adds a product to the shopping list.
	 * @param id the ID of the product to buy
	 * @param quantity the amount of product to buy
	 * @throws Exception 
	 */
	public void addToCart(int id, int quantity) throws Exception;
	
	/**
	 * Removes a product from the shopping list.
	 * @param id the ID of the product to remove
	 * @param quantity the amount of product to remove
	 * @throws Exception 
	 */
	public void removeFromCart(int id, int quantity) throws Exception;
	
	/**
	 * Gets the total price of all the products from the list.
	 * @return the total price in US$
	 */
	public double getTotalPrice();
	
	/**
	 * Empties the shopping list.
	 */
	public void clearCart();
	
	/**
	 * Closes the shopping cart.
	 * @return the shopping list of products
	 */
	public List<ProductAmount> closeCart();
}
