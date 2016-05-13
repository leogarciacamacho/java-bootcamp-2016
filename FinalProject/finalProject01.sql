CREATE DATABASE shoppingCart;
USE shoppingCart;

CREATE TABLE users(
userName VARCHAR(30) NOT NULL,
pass VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
PRIMARY KEY (userName)
);

CREATE TABLE products(
productId INT NOT NULL,
productName VARCHAR(30) NOT NULL,
category VARCHAR(30) NOT NULL,
price DOUBLE NOT NULL,
PRIMARY KEY (productId)
);

CREATE TABLE carts(
cartId INT NOT NULL,
userName VARCHAR(30) NOT NULL,
PRIMARY KEY (cartId),
KEY cartsFk1 (userName),
CONSTRAINT cartsFk1 FOREIGN KEY (userName)
REFERENCES users (userName) ON UPDATE CASCADE
);

CREATE TABLE cartItems(
cartId INT NOT NULL,
productId INT NOT NULL,
quantity INT NOT NULL,
PRIMARY KEY (cartId, productId),
CONSTRAINT cartItemsFk1 FOREIGN KEY (cartId)
REFERENCES carts (cartId) ON UPDATE CASCADE,
CONSTRAINT cartItemsFk2 FOREIGN KEY (productId)
REFERENCES products (productId) ON UPDATE CASCADE
);