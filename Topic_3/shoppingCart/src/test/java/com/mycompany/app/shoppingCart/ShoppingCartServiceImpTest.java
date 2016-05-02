package com.mycompany.app.shoppingCart;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.app.shoppingCart.Services.ShoppingCartService;
import com.mycompany.app.shoppingCart.Services.ShoppingCartServiceImp;
import com.mycompany.app.shoppingCart.buisnessObject.ProductAmount;
import com.mycompany.app.shoppingCart.buisnessObject.ShoppingCart;
import com.mycompany.app.shoppingCart.buisnessObject.User;
import com.mycompany.app.shoppingCart.catalogs.UserCatalog;
import com.mycompany.app.shoppingCart.forTesting.Init;

public class ShoppingCartServiceImpTest {
	private ShoppingCartService shoppingCartService;
	private ShoppingCart shoppingCart;
	
	@Before
	public void setUp() throws Exception {
		shoppingCartService = new ShoppingCartServiceImp();
		shoppingCart = new ShoppingCart();
		Init.init();
	}
	
	@Test  //this is only for personal testing, not for using TDD
	public void generalTesting() throws Exception {
		List<ProductAmount> purchase = new ArrayList<ProductAmount>();
		assertEquals(0,purchase.size());
		shoppingCartService.addToCart(1, 2, shoppingCart);
		shoppingCartService.addToCart(1, 3, shoppingCart);
		shoppingCartService.addToCart(2, 4, shoppingCart);
		shoppingCartService.addToCart(3, 5, shoppingCart);
		shoppingCartService.removeFromCart(2, 3, shoppingCart);
		shoppingCartService.removeFromCart(3, 5, shoppingCart);
		shoppingCartService.addToCart(1, 1000, shoppingCart);		//this shows a warning message
		assertEquals(5500, shoppingCartService.getTotalPrice(shoppingCart),1);
		purchase = shoppingCartService.closeCart(shoppingCart);
		assertEquals(2,purchase.size());
		assertEquals(5,purchase.get(0).getQuantity());
		assertEquals(1,purchase.get(1).getQuantity());
		shoppingCartService.clearCart(shoppingCart);
		assertEquals(0,purchase.size());
		
		UserCatalog.getInstance().add(new User("juanperez", "jorge@gmail.com", "jorge123"));   	//this shows a warning message		
	}
}
