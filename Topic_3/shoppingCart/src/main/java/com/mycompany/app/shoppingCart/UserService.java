package com.mycompany.app.shoppingCart;

/**
 * This interface manages the implementation of the user.
 * @author Leandro Garcia Camacho
 * @version 1.0
 * @since 2016-04-27
 */
public interface UserService {
	
	/**
	 * Adds a new user to the Database.
	 * @param user the user that will be added
	 */
	public void add(User user);	
	
	/**
	 * Returns a specific user, searched by the ID.
	 * @param id the ID of the user.
	 * @return a User object
	 */
	public User getUser(int id);
	
	/**
	 * Updates an existing user in the Database.
	 * @param user the user with an existing ID with the modification to save
	 */
	public void update(User user);
	
	/**
	 * Deletes an existing user in the Database.
	 * @param user the user that will be deleted
 	 */
	public void delete(User user);
}
