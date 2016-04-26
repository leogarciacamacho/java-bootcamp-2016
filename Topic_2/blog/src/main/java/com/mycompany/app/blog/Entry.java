package com.mycompany.app.blog;

public class Entry {
	private static int idGenerator = 1;
	private int id;
	private String title;
	private String body;
	
	public Entry(String title, String body) {
		this.title = title;
		this.body = body;
		id = idGenerator;
		idGenerator++;
	}
	
	public int getId() {
		return id;
	}
}
