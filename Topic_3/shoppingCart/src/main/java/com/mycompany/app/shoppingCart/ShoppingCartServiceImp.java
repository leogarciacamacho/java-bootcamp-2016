package com.mycompany.app.shoppingCart;

import java.util.ArrayList;

public class ShoppingCartServiceImp implements ShoppingCartService {
	
	
	private ArrayList<Product> shoppingList;
	private ProductDataAcces productDataAcces;

	public ShoppingCartServiceImp(){
		shoppingList = new ArrayList<Product>();
		productDataAcces = new ProductDataAccesImp();
	}
	
	public void addToCart(int id, int quantity) {
		  Product product = productDataAcces.getProduct(id);
		  if (product != null && quantity <= product.getStock()) {
		   Product productToAdd = new Product(product.getId(),product.getName(),0,product.getPrice());
		   int newStock = product.getStock() - quantity;
		   product.setStock(newStock);
		   boolean alreadyInList = false;
		   for (Product productInList : shoppingList) {
		    if(productInList.getId() == productToAdd.getId()) {
		     alreadyInList = true;
		     productInList.setStock(productInList.getStock() + quantity); 
		     break;
		    }
		   }
		   if(!alreadyInList) {
		    productToAdd.setStock(quantity);
		    shoppingList.add(productToAdd);
		   }  
		  }
	}

	public ArrayList<Product> closeCart() {
		return shoppingList;
	}

}
