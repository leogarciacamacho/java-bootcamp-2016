package com.mycompany.app.shoppingCart.services;

import java.util.List;

import com.mycompany.app.shoppingCart.buisnessObject.ProductAmount;
import com.mycompany.app.shoppingCart.buisnessObject.ShoppingCart;

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
	 * @param shoppingCart the shopping cart
	 * @throws Exception 
	 */
	public void addToCart(int id, int quantity, ShoppingCart shoppingCart) throws Exception;
	
	/**
	 * Removes a product from the shopping list.
	 * @param id the ID of the product to remove
	 * @param quantity the amount of product to remove
	 * @param shoppingCart the shopping cart
	 * @throws Exception 
	 */
	public void removeFromCart(int id, int quantity, ShoppingCart shoppingCart) throws Exception;
	
	/**
	 * Gets the total price of all the products from the list.
	 * @param shoppingCart the shopping cart
	 * @return the total price in US$
	 */
	public double getTotalPrice(ShoppingCart shoppingCart);
	
	/**
	 * Empties the shopping list.
	 * @param shoppingCart the shopping cart
	 */
	public void clearCart(ShoppingCart shoppingCart);
	
	/**
	 * Closes the shopping cart.
	 * @param shoppingCart the shopping cart
	 * @return the shopping list of products
	 */
	public List<ProductAmount> closeCart(ShoppingCart shoppingCart);
}
