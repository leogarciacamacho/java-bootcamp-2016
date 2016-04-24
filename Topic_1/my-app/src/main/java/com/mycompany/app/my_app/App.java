package com.mycompany.app.my_app;

public class App {
	private int num1,num2;
	
	public App(int a, int b) {
		this.num1 = a;
		this.num2 = b;
	}
	
	public int major () {
		if(num1>num2){
			return num1;
		}
		return num2;
	}
	
	public int minor () {
		if(num1<num2){
			return num1;
		}
		return num2;
	}
}
