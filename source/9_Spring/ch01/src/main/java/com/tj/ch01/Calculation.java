package com.tj.ch01;
public class Calculation {
	private int num1;
	private int num2;
	public void add() {
		System.out.println("더하기");
		System.out.println(num1 +" + "+num2 + " = "+(num1+num2));
	}
	public void sub() {
		System.out.println("빼기");
		System.out.println(num1 +" - "+num2 + " = "+(num1-num2));
	}
	public void mul() {
		System.out.println("곱하기");
		System.out.println(num1 +" * "+num2 + " = "+(num1*num2));
	}
	public void div() {
		System.out.println("나누기");
		System.out.println(num1 +" / "+num2 + " = "+(num1/num2));
	}
	public void setNum1(int num1) {this.num1 = num1;}
	public void setNum2(int num2) {this.num2 = num2;}
}
