package com.mycompany.shoppingCart.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.shoppingCart.bo.User;
import com.mycompany.shoppingCart.dao.UserDao;
import com.mycompany.shoppingCart.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(String userName) {
		return userDao.getUser(userName);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
