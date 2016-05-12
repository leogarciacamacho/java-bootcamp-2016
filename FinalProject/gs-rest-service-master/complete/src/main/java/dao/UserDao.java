package dao;

import java.sql.SQLException;
import java.util.List;

import bo.User;

public interface UserDao {

	public void addUser(User user) throws SQLException;

	public User getUser(String userName) throws SQLException;

	public void updateUser(User user) throws SQLException;

	public void deleteUser(User user) throws SQLException;

	public List<User> getUsers() throws SQLException;
}