package com.mycompany.app.shoppingCart.Services;

import com.mycompany.app.shoppingCart.buisnessObject.User;
import com.mycompany.app.shoppingCart.stub.DataBaseConnectorStub;

public class UserServiceImp implements UserService {

	public void add(User user) {
		DataBaseConnectorStub.getInstance().addUser(user);
	}

	public User get(int id) throws Exception {
		return DataBaseConnectorStub.getInstance().getUser(id);
	}

	public void update(User user) {
		DataBaseConnectorStub.getInstance().updateUser(user);
	}

	public void delete(User user) {
		DataBaseConnectorStub.getInstance().deleteUser(user);
	}
	
}
