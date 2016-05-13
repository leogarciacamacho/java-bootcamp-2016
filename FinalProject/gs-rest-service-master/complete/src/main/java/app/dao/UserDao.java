package app.dao;

import java.sql.SQLException;
import java.util.List;

import app.domain.User;

public interface UserDao {

	void addUser(User user) throws SQLException, ClassNotFoundException;

	User getUser(String userName) throws SQLException, ClassNotFoundException;

	void updateUser(String UserName, User user) throws SQLException, ClassNotFoundException;

	void deleteUser(String userName) throws SQLException, ClassNotFoundException;

	List<User> getUsers() throws SQLException, ClassNotFoundException;
}