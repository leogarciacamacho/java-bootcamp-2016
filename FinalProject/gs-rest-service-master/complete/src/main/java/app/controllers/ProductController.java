package app.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Product;
import app.services.ProductService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Products", description = "for products management")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products/{productName}", method = RequestMethod.GET)
	@ApiOperation(value = "Get product by name", response = Product.class, notes = "Returns one product")
	public ResponseEntity<Product> getProduct(@PathVariable("productName") String productName) throws SQLException, ClassNotFoundException {
		Product product = productService.getProduct(productName);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ApiOperation(value = "Get products", response = Product.class, notes = "Returns all the products")
	public ResponseEntity<List<Product>> getProducts() throws SQLException, ClassNotFoundException {
		List<Product> products = productService.getProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = " /products/category=?{category}", method = RequestMethod.GET)
	@ApiOperation(value = "Get products by category", response = Product.class, notes = "Returns all the products from a chosen category")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category) throws SQLException,
			ClassNotFoundException {
		List<Product> products = productService.getProductsByCategory(category);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
