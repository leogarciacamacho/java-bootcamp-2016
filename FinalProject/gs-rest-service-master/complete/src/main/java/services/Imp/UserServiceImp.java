package services.Imp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import services.UserService;
import bo.User;
import dao.UserDao;
import dao.imp.UserDaoImp;

@Service
public class UserServiceImp implements UserService {

//	@Autowired
	UserDao userDao = new UserDaoImp();

	public void addUser(User user) throws SQLException {
		userDao.addUser(user);
	}

	public User getUser(String userName) throws SQLException {
		return userDao.getUser(userName);
	}

	public void updateUser(User user) throws SQLException {
		userDao.updateUser(user);
	}

	public void deleteUser(User user) throws SQLException {
		userDao.deleteUser(user);
	}

	public List<User> getUsers() throws SQLException {
		return userDao.getUsers();
	}

}
