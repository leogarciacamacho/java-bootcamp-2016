package com.mycompany.app.shoppingCart.services;

import java.util.List;

import com.mycompany.app.shoppingCart.buisnessObject.Product;
import com.mycompany.app.shoppingCart.buisnessObject.ProductAmount;
import com.mycompany.app.shoppingCart.buisnessObject.ShoppingCart;
import com.mycompany.app.shoppingCart.catalogs.ProductCatalog;
import com.mycompany.app.shoppingCart.catalogs.StockCatalog;

public class ShoppingCartServiceImp implements ShoppingCartService {

	public void addToCart(int id, int quantity, ShoppingCart shoppingCart) throws Exception {
		if(quantity > 0) {
			  Product product = ProductCatalog.getInstance().get(id);
			  int actualStock = StockCatalog.getInstance().get(product);
			  if (quantity <= actualStock) {
				  StockCatalog.getInstance().set(product, actualStock - quantity);
				  shoppingCart.add(product, quantity);				  
			  } else {
				  throw new Exception();
			  }
		}
	}

	public void removeFromCart(int id, int quantity, ShoppingCart shoppingCart) throws Exception {
		if(quantity > 0) {
			Product product = ProductCatalog.getInstance().get(id);
			int actualStock = StockCatalog.getInstance().get(product);
			int toRemove = quantity;
			if(quantity > shoppingCart.get(product)) {
				toRemove = shoppingCart.get(product);
			}
			shoppingCart.remove(product, toRemove);
			StockCatalog.getInstance().set(product, actualStock + toRemove);
		}		
	}

	public double getTotalPrice(ShoppingCart shoppingCart) {
		return shoppingCart.getTotalPrice();
	}

	public void clearCart(ShoppingCart shoppingCart) {
		shoppingCart.clear();
	}

	public List<ProductAmount> closeCart(ShoppingCart shoppingCart) {
		return shoppingCart.getList();
	}

	

	

}
