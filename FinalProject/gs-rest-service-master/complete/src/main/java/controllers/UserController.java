package controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import services.UserService;
import services.Imp.UserServiceImp;
import bo.User;

@RestController
public class UserController {

//	@Autowired
	UserService userService = new UserServiceImp();
	
	@RequestMapping (value = "/users/{userName}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("userName") String userName) throws SQLException {
	       User user = userService.getUser(userName);
		   return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping (value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() throws SQLException {
        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }		
	
}
