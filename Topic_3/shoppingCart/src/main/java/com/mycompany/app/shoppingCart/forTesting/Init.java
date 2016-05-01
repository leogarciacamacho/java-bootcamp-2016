package com.mycompany.app.shoppingCart.forTesting;

import java.util.List;

import com.mycompany.app.shoppingCart.buisnessObject.Product;
import com.mycompany.app.shoppingCart.buisnessObject.ProductAmount;
import com.mycompany.app.shoppingCart.buisnessObject.User;
import com.mycompany.app.shoppingCart.catalogs.ProductCatalog;
import com.mycompany.app.shoppingCart.catalogs.StockCatalog;
import com.mycompany.app.shoppingCart.catalogs.UserCatalog;

public class Init {
	public static void init() throws Exception {
		UserCatalog userCatalog = UserCatalog.getInstance();
		userCatalog.add(new User("juanperez", "juanperez@gmail.com", "juan123"));
		userCatalog.add(new User("ricardolopez", "ricardolopez@gmail.com", "ricardo123"));
		userCatalog.add(new User("hernancattaneo", "hernancattaneo@gmail.com", "hernan123"));
		
		List<Product> products = ProductCatalog.getInstance().getList();
		products.add(new Product(1,"table", "table description", 1000));
		products.add(new Product(2,"chair", "chair description", 500));
		products.add(new Product(3,"desk", "desk description", 2000));
		products.add(new Product(4,"bed", "bed description", 3000));
		products.add(new Product(5,"library", "library description", 2500));
		
		List<ProductAmount> productAmounts = StockCatalog.getInstance().getList();
		productAmounts.add(new ProductAmount(ProductCatalog.getInstance().get(1), 50));
		productAmounts.add(new ProductAmount(ProductCatalog.getInstance().get(2), 50));
		productAmounts.add(new ProductAmount(ProductCatalog.getInstance().get(3), 50));
		productAmounts.add(new ProductAmount(ProductCatalog.getInstance().get(4), 50));
		productAmounts.add(new ProductAmount(ProductCatalog.getInstance().get(5), 50));		
	}
}
