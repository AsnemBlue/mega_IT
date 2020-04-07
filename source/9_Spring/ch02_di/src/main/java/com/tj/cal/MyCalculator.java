package com.tj.cal;

public class MyCalculator {
	private int num1;
	private int num2;
	private Calculator calculator;
	public void add() {
		calculator.addition(num1, num2);
	}
	public void sub() {
		calculator.subtraction(num1, num2);
	}
	public void mul() {
		calculator.multiplication(num1, num2);
	}
	public void div() {
		calculator.division(num1, num2);
	}
	public int getNum1() {return num1;}
	public void setNum1(int num1) {this.num1 = num1;}
	public int getNum2() {return num2;}
	public void setNum2(int num2) {this.num2 = num2;}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
}
