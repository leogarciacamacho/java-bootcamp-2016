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

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import app.domain.Login;
import app.domain.Product;
import app.domain.User;
import app.services.UserService;

@RestController
@RequestMapping(value = "/api")
@Api(value="Users", description="for users management")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/{userName}", method = RequestMethod.GET)
	@ApiOperation(value="Get user by username", response= Product.class, notes="Returns one user")
	public ResponseEntity<User> getUser(@PathVariable("userName") String userName) throws SQLException, ClassNotFoundException {
		User user = userService.getUser(userName);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ApiOperation(value="Get users", response= Product.class, notes="Returns all the users")
	public ResponseEntity<List<User>> getUsers() throws SQLException, ClassNotFoundException {
		List<User> users = userService.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	@ApiOperation(value="Add user", response= Product.class, notes="Creates a new user")
	public ResponseEntity<User> addUser(@RequestBody User user) throws ClassNotFoundException, SQLException {
		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/users/{userName}", method = RequestMethod.PUT)
	@ApiOperation(value="Update user by username", response= Product.class, notes="Updates any data from the user")
	public ResponseEntity<User> updateUser(@PathVariable("userName") String userName,
		@RequestBody User user) throws ClassNotFoundException, SQLException {
		userService.updateUser(userName, user);
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{userName}", method = RequestMethod.DELETE)
	@ApiOperation(value="Delete user by username", response= Product.class, notes="Deletes the user")
	public ResponseEntity<String> deleteUser(@PathVariable("userName") String userName) throws SQLException, ClassNotFoundException {
		userService.deleteUser(userName);
		return new ResponseEntity<String>(userName + " deleted.", HttpStatus.OK);
	}

	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	@ApiOperation(value="Login user", response= Product.class, notes="Verificates the username and password and returns the user")
	public ResponseEntity<User> loginUser(@RequestBody Login login) throws Exception {
		User user = userService.validateUser(login);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
