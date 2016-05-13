package app.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Login;
import app.domain.User;
import app.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/{userName}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("userName") String userName) throws SQLException, ClassNotFoundException {
		User user = userService.getUser(userName);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() throws SQLException, ClassNotFoundException {
		List<User> users = userService.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) throws ClassNotFoundException, SQLException {
		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/users/{userName}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("userName") String userName,
		@RequestBody User user) throws ClassNotFoundException, SQLException {
		userService.updateUser(userName, user);
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{userName}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userName") String userName) throws SQLException, ClassNotFoundException {
		userService.deleteUser(userName);
		return new ResponseEntity<String>(userName + " deleted.", HttpStatus.OK);
	}

	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public ResponseEntity<User> loginUser(@RequestBody Login login) throws Exception {
		User user = userService.validateUser(login);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
