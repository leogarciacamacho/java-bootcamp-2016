package com.mycompany.app.shoppingCart;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartServiceImpTest {
	private ShoppingCartService shoppingCartService;
	
	@Before
	public void setUp() {
		shoppingCartService = new ShoppingCartServiceImp();
	}
	
	@Test
	public void addsNewItemsToTheShoppingCartAndCloseTheCart() {
		ArrayList<Product> purchase = new ArrayList<Product>();
		assertEquals(0,purchase.size());
		shoppingCartService.addToCart(1, 2);
		shoppingCartService.addToCart(1, 3);
		shoppingCartService.addToCart(2, 4);
		purchase = shoppingCartService.closeCart();
		assertEquals(2,purchase.size());
		assertEquals(5,purchase.get(0).getStock());
		
	}
}
