package com.mycompany.app.blog;

public class Entry {
	private int id;
	private String title;
	private String body;
	
	public Entry(String title, String body) {
		this.title = title;
		this.body = body;
		id = IdGenerator.getInstance().getId();
	}
	
	public int getId() {
		return id;
	}
}
