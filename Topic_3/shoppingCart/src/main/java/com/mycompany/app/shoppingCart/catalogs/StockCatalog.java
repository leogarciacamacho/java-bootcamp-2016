package com.mycompany.app.shoppingCart.catalogs;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.app.shoppingCart.buisnessObject.Product;
import com.mycompany.app.shoppingCart.buisnessObject.ProductAmount;

public class StockCatalog {
	private List<ProductAmount> productAmounts = new ArrayList<ProductAmount>();
	private static StockCatalog instance = null;
	
	private StockCatalog() throws Exception {
	}
	
	public static StockCatalog getInstance() throws Exception {
		if(instance == null) {
			instance = new StockCatalog();
		}
		return instance;
	}
	
	public int get(Product product) throws Exception {							
		for(ProductAmount productAmount : productAmounts) {
			if(productAmount.getProduct() == product) {
				return productAmount.getQuantity();
			}
		}
		throw new Exception();
	}
	
	public void set(Product product, int quantity) {
		for(ProductAmount productAmount : productAmounts) {
			if(productAmount.getProduct() == product) {
				productAmount.setQuantity(quantity);
				break;
			}
		}
	}
	
	public List<ProductAmount> getList() {
		return productAmounts;
	}

}
