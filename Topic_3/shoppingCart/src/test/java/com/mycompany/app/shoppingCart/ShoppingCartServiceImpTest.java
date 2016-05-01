package com.mycompany.app.shoppingCart;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.app.shoppingCart.Services.ShoppingCartService;
import com.mycompany.app.shoppingCart.Services.ShoppingCartServiceImp;
import com.mycompany.app.shoppingCart.buisnessObject.ProductAmount;
import com.mycompany.app.shoppingCart.forTesting.Init;

public class ShoppingCartServiceImpTest {
	private ShoppingCartService shoppingCartService;
	
	@Before
	public void setUp() throws Exception {
		shoppingCartService = new ShoppingCartServiceImp();
		Init.init();
	}
	
	@Test  //this is only for personal testing, not for using TDD
	public void generalTesting() throws Exception {
		List<ProductAmount> purchase = new ArrayList<ProductAmount>();
		shoppingCartService.logIn("juanperez", "juan123");
		assertEquals(0,purchase.size());
		shoppingCartService.addToCart(1, 2);
		shoppingCartService.addToCart(1, 3);
		shoppingCartService.addToCart(2, 4);
		shoppingCartService.addToCart(3, 5);
		shoppingCartService.removeFromCart(2, 3);
		shoppingCartService.removeFromCart(3, 5);
		assertEquals(5500, shoppingCartService.getTotalPrice(),1);
		purchase = shoppingCartService.closeCart();
		assertEquals(2,purchase.size());
		assertEquals(5,purchase.get(0).getQuantity());
		assertEquals(1,purchase.get(1).getQuantity());
		shoppingCartService.clearCart();
		assertEquals(0,purchase.size());
	}
}
