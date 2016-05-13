package app.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.connector.DbConnector;
import app.dao.UserDao;
import app.domain.User;

@Repository
public class UserDaoImp implements UserDao {

	@Override
	@Transactional
	public void addUser(User user) throws SQLException, ClassNotFoundException {
		String userName = user.getUserName();
		String pass = user.getPass();
		String email = user.getEmail();
		String query = "INSERT INTO users VALUES (?, ?, ?)";

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, email);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public User getUser(String userName) throws SQLException, ClassNotFoundException {
		User user = new User();
		String query = "SELECT * FROM users u where u.userName = ?";

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			preparedStatement.setString(1, userName);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				user.setUserName(userName);
				user.setPass(result.getString("pass"));
				user.setEmail(result.getString("email"));
			}

		} catch (SQLException e) {
			throw e;
		}
		return user;
	}

	@Override
	@Transactional
	public void updateUser(String userName, User user) throws SQLException, ClassNotFoundException {
		String newUserName = user.getUserName();
		String pass = user.getPass();
		String email = user.getEmail();
		String query = "UPDATE users SET userName = ?, pass = ?, email = ? WHERE userName = ?";

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			preparedStatement.setString(1, newUserName);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, userName);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public void deleteUser(String userName) throws SQLException, ClassNotFoundException {
		String query = "DELETE FROM users WHERE userName = ?";

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public List<User> getUsers() throws SQLException, ClassNotFoundException {
		List<User> users = new ArrayList<User>();
		String query = "SELECT * FROM users";

		try {
			PreparedStatement preparedStatement = DbConnector.getInstance().getConnection().prepareStatement(query);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				User user = new User();
				user.setUserName(result.getString("userName"));
				user.setPass(result.getString("pass"));
				user.setEmail(result.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			throw e;
		}
		return users;
	}

}
