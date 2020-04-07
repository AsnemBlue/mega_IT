package com.tj.ex09;
public class MainClass {
	public static void main(String[] args) {
		//I a = new A();
		I a = new B();
		User user = new User();
		user.use(a);
	}
}