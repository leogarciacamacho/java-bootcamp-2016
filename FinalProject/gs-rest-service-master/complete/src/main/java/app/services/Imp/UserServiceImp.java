package app.services.Imp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.UserDao;
import app.domain.Login;
import app.domain.User;
import app.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) throws SQLException, ClassNotFoundException {
		userDao.addUser(user);
	}

	@Override
	public User getUser(String userName) throws SQLException, ClassNotFoundException {
		return userDao.getUser(userName);
	}

	@Override
	public void updateUser(String userName, User user) throws SQLException, ClassNotFoundException {
		userDao.updateUser(userName, user);
	}

	@Override
	public void deleteUser(String userName) throws SQLException, ClassNotFoundException {
		userDao.deleteUser(userName);
	}

	@Override
	public List<User> getUsers() throws SQLException, ClassNotFoundException {
		return userDao.getUsers();
	}

	@Override
	public User validateUser(Login login) throws Exception {
		User user = this.getUser(login.getUserName());
		if (user.getUserName().equals(login.getUserName()) && user.getPass().equals(login.getPass())) {
			return user;
		}
		throw new Exception();
	}
}
