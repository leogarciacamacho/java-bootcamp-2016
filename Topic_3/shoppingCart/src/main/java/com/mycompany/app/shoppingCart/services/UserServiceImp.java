package com.mycompany.app.shoppingCart.services;

import com.mycompany.app.shoppingCart.buisnessObject.User;
import com.mycompany.app.shoppingCart.catalogs.UserCatalog;

public class UserServiceImp implements UserService {

	public void add(User user) throws Exception {
		UserCatalog.getInstance().add(user);
	}

	public User get(int id) throws Exception {
		return UserCatalog.getInstance().get(id);
	}

	public void update(User user) {
		UserCatalog.getInstance().update(user);
	}

	public void delete(User user) {
		UserCatalog.getInstance().delete(user);
	}
	
}
