package com.mycompany.app.shoppingCart.generator;

public class IdGenerator {
	private int userId;
	private static IdGenerator idGenerator = null;
	
	private IdGenerator() {
		userId = 0;
	}
	
	public static IdGenerator getInstance() {
		if(idGenerator == null) {
			idGenerator = new IdGenerator();
		}
		return idGenerator;
	}
	
	public int getUserId() {
		userId++;
		return userId;
	}
}
