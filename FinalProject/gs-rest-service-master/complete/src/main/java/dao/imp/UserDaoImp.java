package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bo.User;
import connector.DbConnector;
import dao.UserDao;

@Repository
public class UserDaoImp implements UserDao {

	@Transactional
	public void addUser(User user) throws SQLException {
		Connection conn = DbConnector.getInstance().getConnection();
		String userName = user.getUserName();
		String pass = user.getPass();
		String email = user.getEmail();
		String query = "INSERT INTO users VALUES (?, ?, ?)";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, email);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Transactional
	public User getUser(String userName) throws SQLException {
		User user = new User();
		Connection conn = DbConnector.getInstance().getConnection();
		String query = "SELECT * FROM users u where u.userName = ?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
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

	@Transactional
	public void updateUser(User user) throws SQLException {
		Connection conn = DbConnector.getInstance().getConnection();
		String userName = user.getUserName();
		String pass = user.getPass();
		String email = user.getEmail();
		String query = "UPDATE users SET pass = ?, email = ? WHERE userName = ?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, pass);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, userName);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Transactional
	public void deleteUser(User user) throws SQLException {
		Connection conn = DbConnector.getInstance().getConnection();
		String userName = user.getUserName();
		String pass = user.getPass();
		String email = user.getEmail();
		String query = "DELETE FROM users WHERE userName = ? AND pass = ? AND email = ?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, email);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Transactional
	public List<User> getUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		Connection conn = DbConnector.getInstance().getConnection();
		String query = "SELECT * FROM users";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
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
