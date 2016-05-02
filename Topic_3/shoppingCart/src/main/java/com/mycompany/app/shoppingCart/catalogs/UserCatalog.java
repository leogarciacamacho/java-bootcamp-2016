package com.mycompany.app.shoppingCart.catalogs;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import com.mycompany.app.shoppingCart.buisnessObject.User;
import com.mycompany.app.shoppingCart.generator.IdGenerator;

public class UserCatalog {
	private Set<User> users = new HashSet<User>();
	private static UserCatalog instance = null;
	
	private UserCatalog() {
	}
	
	public static UserCatalog getInstance() {
		if(instance == null) {
			instance = new UserCatalog();
		}
		return instance;
	}
	
	public int add(User user) {
		
		if(!users.contains(user)) {
			int id = IdGenerator.getInstance().getUserId();
			user.setId(id);
			users.add(user);
			return user.getId();
		} else {
			JOptionPane.showMessageDialog(null, "This user name already exists", "Warning", JOptionPane.WARNING_MESSAGE);
			return 0;
		}
		
	}
	
	public User get(int id) throws Exception {
		for(User user : users){
			if(user.getId() == id) {
				return user;
			}
		}
		throw new Exception();
	}
	
	public void update(User user) {
		for(User user2 : users) {
			if(user2.getId() == user.getId()) {
				user2 = user;
				break;
			}
		}
	}
	
	public void delete(User user) {		
		users.remove(user);		
	}	
}
