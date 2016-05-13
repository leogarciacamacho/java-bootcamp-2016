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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import app.domain.Cart;
import app.domain.Product;
import app.domain.User;
import app.services.CartService;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Shopping carts", description = "for carts management")
public class ShoppingCartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/carts/add", method = RequestMethod.POST)
	@ApiOperation(value = "Add new cart", response = Product.class, notes = "Creates a new cart for the chosen user an returns it")
	public ResponseEntity<Cart> addNewCart(@RequestBody User user) throws ClassNotFoundException, SQLException {
		Cart cart = cartService.addNewCart(user);
		return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/carts/{cartId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get cart by id", response = Product.class, notes = "Returns one cart")
	public ResponseEntity<Cart> getCart(@PathVariable("cartId") int cartId) throws SQLException, ClassNotFoundException {
		Cart cart = cartService.getCart(cartId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@RequestMapping(value = "/carts/addproduct", method = RequestMethod.POST)
	@ApiOperation(value = "Add item to cart", response = Product.class, notes = "Inserts an item to the cart and returns the cart")
	public ResponseEntity<Cart> addToCart(@RequestBody Product product, @RequestParam(value = "cartid", required = true) int cartId,
			@RequestParam(value = "quantity", required = true) int quantity) throws ClassNotFoundException, SQLException {
		cartService.addToCart(cartId, product, quantity);
		return new ResponseEntity<Cart>(cartService.getCart(cartId), HttpStatus.OK);
	}

	@RequestMapping(value = "/carts", method = RequestMethod.GET)
	@ApiOperation(value = "Get carts", response = Product.class, notes = "Returns all the carts")
	public ResponseEntity<List<Cart>> getCarts() throws ClassNotFoundException, SQLException {
		List<Cart> carts = cartService.getCarts();
		return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
	}

	@RequestMapping(value = "/carts/user", method = RequestMethod.POST)
	@ApiOperation(value = "Get carts by user", response = Product.class, notes = "Returns all the carts from the chosen user")
	public ResponseEntity<List<Cart>> getCartsByUser(@RequestBody User user) throws ClassNotFoundException, SQLException {
		List<Cart> carts = cartService.getCartsByUser(user);
		return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
	}

	@RequestMapping(value = "/carts/buyproducts", method = RequestMethod.POST)
	@ApiOperation(value = "Buy products", response = Product.class, notes = "Set the total amount of the items in a cart and returns the cart")
	public ResponseEntity<Cart> buyProducts(@RequestBody Cart cart) throws ClassNotFoundException, SQLException {
		Cart closedCart = cartService.buyProducts(cart);
		return new ResponseEntity<Cart>(closedCart, HttpStatus.OK);
	}
}
