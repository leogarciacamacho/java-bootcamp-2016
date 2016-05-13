package app.services;

import java.sql.SQLException;
import java.util.List;

import app.domain.Login;
import app.domain.User;

public interface UserService {

	void addUser(User user) throws SQLException, ClassNotFoundException;

	User getUser(String userName) throws SQLException, ClassNotFoundException;

	void updateUser(String userName, User user) throws SQLException, ClassNotFoundException;

	void deleteUser(String userName) throws SQLException, ClassNotFoundException;

	List<User> getUsers() throws SQLException, ClassNotFoundException;
	
	User validateUser(Login login) throws Exception;
}
