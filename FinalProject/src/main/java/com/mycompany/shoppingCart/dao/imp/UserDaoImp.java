package com.mycompany.shoppingCart.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.shoppingCart.bo.User;
import com.mycompany.shoppingCart.connector.DbConnector;
import com.mycompany.shoppingCart.dao.UserDao;

@Repository
public class UserDaoImp implements UserDao {

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(String userName) {
		User user = new User();
		Connection conn = DbConnector.getInstance().getConnection();
		String query = "SELECT * FROM users u where u.userName = ?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, userName);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				user.setUserId(result.getInt("userId"));
				user.setUserName(userName);
				user.setPass(result.getString("pass"));
				user.setEmail(result.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
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
