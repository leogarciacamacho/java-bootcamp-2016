package com.mycompany.app.shoppingCart.buisnessObject;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<ProductAmount> shoppingList = new ArrayList<ProductAmount>();
	private boolean alreadyInList;
	
	public void add(Product product, int quantity) {
		if(quantity > 0) {
			alreadyInList = false;
			for(ProductAmount productAmount : shoppingList) {
				if(productAmount.getProduct() == product) {
					productAmount.setQuantity(productAmount.getQuantity() + quantity);
					alreadyInList = true;
					break;
				}
			}
			if(!alreadyInList){
				shoppingList.add(new ProductAmount(product, quantity));
			}
		}
	}
	
	public void remove(Product product, int quantity) {
		if(quantity > 0) {
			for(ProductAmount productAmount : shoppingList) {
				if(productAmount.getProduct() == product) {
					if(productAmount.getQuantity() <= quantity) {
						shoppingList.remove(productAmount);
					} else {
					productAmount.setQuantity(productAmount.getQuantity() - quantity);
					}
					break;
				}
			}
		}
	}	
	
	public int get(Product product) {
		for(ProductAmount productAmount : shoppingList) {
			if(productAmount.getProduct() == product) {
				return productAmount.getQuantity();
			}
		}
		return 0;
	}
	
	public double getTotalPrice() {
		double total = 0;
		for(ProductAmount productAmount : shoppingList) {
			total += productAmount.getProduct().getPrice() * (double)productAmount.getQuantity();
		}
		return total;
	}
	
	public void clear() {
		shoppingList.clear();
	}
	
	public List<ProductAmount> getList() {
		return shoppingList;
	}
}
