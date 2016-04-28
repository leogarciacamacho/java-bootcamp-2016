package com.mycompany.app.shoppingCart;

public class UserServiceImp implements UserService {
	private UserDataAcces userDataAcces = new UserDataAccesImp();

	public void add(User user) {
		userDataAcces.add(user);
	}

	public User getUser(int id) {
		return userDataAcces.getUser(id);
	}

	public void update(User user) {
		userDataAcces.update(user);
	}

	public void delete(User user) {
		userDataAcces.delete(user);
	}
	
}
