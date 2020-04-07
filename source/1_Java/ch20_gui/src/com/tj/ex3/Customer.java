package com.tj.ex3;

public class Customer {
	private String phone;
	private String name;
	private int point;
	public Customer() { }
	public Customer(String phone, String name) {
		this.phone = phone;
		this.name = name;
		point = 1000;
	}
	@Override
	public String toString() {
		return name + "("+phone+")´Ô Æ÷ÀÎÆ®" + point;
	}
	public String getPhone() {return phone;}
	public String getName() {return name;}
	public int getPoint() {return point;}
}
