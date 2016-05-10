package com.mycompany.shoppingCart.services;

import java.util.List;

import com.mycompany.shoppingCart.bo.User;

public interface UserService {

	public void addUser(User user);

	public User getUser(String userName);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> getUsers();
}
