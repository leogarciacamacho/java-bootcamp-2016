package com.mycompany.app.shoppingCart.Services;

import java.util.List;

import com.mycompany.app.shoppingCart.buisnessObject.Product;
import com.mycompany.app.shoppingCart.buisnessObject.ProductAmount;
import com.mycompany.app.shoppingCart.buisnessObject.User;
import com.mycompany.app.shoppingCart.stub.DataBaseConnectorStub;

public class ShoppingCartServiceImp implements ShoppingCartService {
	
	private User userLogged = null;
	
	public void logIn(String userName, String password) {
		if(userLogged == null) {
			for(User user : DataBaseConnectorStub.getInstance().getUsers()) {
				if (user.getUserName() == userName) {
					if(user.getPassword() == password) {
						userLogged = user;
						break;
					}
					System.out.println("Password not valid");
					break;
				}
			}
			if(userLogged == null) {
				System.out.println("User not valid");
			}
		} else {
			System.out.println("You are already logged in");
		}

		
	}
	
	public void logOut() {
		userLogged = null;
	}
	
	public void addToCart(int id, int quantity) throws Exception {
		  if(userLogged != null) {
			  if(quantity > 0) {
				  Product product = DataBaseConnectorStub.getInstance().getProduct(id);
				  int actualStock = DataBaseConnectorStub.getInstance().getProductAmount(product);
				  if (quantity <= actualStock) {
					  DataBaseConnectorStub.getInstance().setProductAmount(product, actualStock - quantity);
					  userLogged.getShoppingCart().add(product, quantity);				  
				  } else {
					  System.out.println("Not enough stock.  Actual stock: " + actualStock);
				  }
			  }
		  } else {
			  System.out.println("Please, log in first");
		  }
	}

	public void removeFromCart(int id, int quantity) throws Exception {
		if(userLogged != null) {
			Product product = DataBaseConnectorStub.getInstance().getProduct(id);
			int actualStock = DataBaseConnectorStub.getInstance().getProductAmount(product);
			int toRemove = quantity;
			if(quantity > userLogged.getShoppingCart().get(product)) {
				toRemove = userLogged.getShoppingCart().get(product);
			}
			userLogged.getShoppingCart().remove(product, toRemove);
			DataBaseConnectorStub.getInstance().setProductAmount(product, actualStock + toRemove);
		} else {
			System.out.println("Please, log in first");
		}
	}

	public double getTotalPrice() {
		if(userLogged != null) {
			return userLogged.getShoppingCart().getTotalPrice();
		} else {
			System.out.println("Please, log in first");
			return 0;
		}
	}

	public void clearCart() {
		if(userLogged != null) {
			userLogged.getShoppingCart().clear();	
		} else {
			System.out.println("Please, log in first");
		}
	}

	public List<ProductAmount> closeCart() {
		if(userLogged != null) {
			return userLogged.getShoppingCart().getList();
		} else {
			System.out.println("Please, log in first");
			return null;
		}
	}

	

	

}
