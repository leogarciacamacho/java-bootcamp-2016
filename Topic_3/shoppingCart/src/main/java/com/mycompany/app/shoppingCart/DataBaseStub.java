package com.mycompany.app.shoppingCart;

import java.util.ArrayList;

public class DataBaseStub {
	private static ArrayList<User> users = null;
	private static ArrayList<Product> products = null;
	
	public static ArrayList<User> getListOfUsers() {
		if(users == null) {
			users = new ArrayList<User>();
			users.add(new User(1, "juanperez", "juanperez@gmail.com", "juan123"));
			users.add(new User(2, "ricardolopez", "ricardolopez@gmail.com", "ricardo123"));
			users.add(new User(3, "hernancattaneo" ,"hernancattaneo@gmail.com", "hernan123"));
			users.add(new User(4, "raulgarcia", "raulgarcia@gmail.com", "raul123"));
			users.add(new User(5, "arnoldodiaz", "arnoldodiaz@gmail.com", "arnoldo123"));			
		}
		return users;
	}
	
	public static ArrayList<Product> getListOfProducts()	{
		if(products == null) {
			products = new ArrayList<Product>();
			products.add(new Product(1, "table", 50, 1000));
			products.add(new Product(2, "chair", 50, 500));
			products.add(new Product(3, "desk", 50, 2000));
			products.add(new Product(4, "bed", 50, 3000));
			products.add(new Product(5, "library", 50, 2500));
		}
		return products;
	}
	
	public static void setListOfUsers(ArrayList<User> users) {
		DataBaseStub.users = users;
	}
}
