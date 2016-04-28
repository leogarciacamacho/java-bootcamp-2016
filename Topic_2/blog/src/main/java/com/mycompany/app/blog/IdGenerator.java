package com.mycompany.app.blog;

public class IdGenerator {
	private int id;
	private static IdGenerator idGenerator = null;
	
	private IdGenerator() {
		id = 0;
	}
	
	public static IdGenerator getInstance() {
		if(idGenerator == null) {
			idGenerator = new IdGenerator();
		}
		return idGenerator;
	}
	
	public int getId() {
		id++;
		return id;
	}

}
