package com.mycompany.app.shoppingCart;

import java.util.ArrayList;

public class UserDataAccesImp implements UserDataAcces {

	public void add(User user) {
		ArrayList<User> users = DataBaseStub.getListOfUsers();
		users.add(user);
		DataBaseStub.setListOfUsers(users);
	}

	public User getUser(int id) {
		for (User user: DataBaseStub.getListOfUsers()) {
			if (id == user.getId()) {
				return user;
			}
		}
		return null;
	}

	public void update(User user) {
		ArrayList<User> users = DataBaseStub.getListOfUsers();
		for(User u : users) {
			if(u.getId() == user.getId()) {
				users.set(users.indexOf(u), user);
				DataBaseStub.setListOfUsers(users);
				break;
			}
		}
	}

	public void delete(User user) {
		ArrayList<User> users = DataBaseStub.getListOfUsers();
		for(User u : users) {
			if(u.getId() == user.getId()) {
				users.remove(users.indexOf(u));
				DataBaseStub.setListOfUsers(users);
				break;
			}
		}
	}
	

}
