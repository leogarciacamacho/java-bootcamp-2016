package com.mycompany.app.my_app;

public class App {
	private int a,b;
	
	public App(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int major () {
		if(a>b){
			return a;
		}
		return b;
	}
	
	public int minor () {
		if(a<b){
			return a;
		}
		return b;
	}
}
