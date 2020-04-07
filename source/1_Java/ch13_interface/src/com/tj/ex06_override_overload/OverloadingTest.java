package com.tj.ex06_override_overload;

public class OverloadingTest {
	private int i1;
	private int i2;
	public OverloadingTest() {}  //생성자 함수 오버로딩
	public OverloadingTest(int i) {
		i1 = i2 = i;
	}
	public OverloadingTest(int i1, int i2) {
		this.i1 = i1;
		this.i2 = i2;
	}
	public void calculate() {   // 일반함수의 오버로딩
		System.out.println("i1+i2="+(i1+i2));
	}
	public void calculate(char op) { // 객체이름.calculate()  객체이름.calculate('*')
		switch (op) {
		case '+':
			calculate();break;
		case '-':
			System.out.println("i1-i2 = "+(i1-i2));break;
		case '*':
			System.out.println("i1*i2 = "+(i1*i2));break;
		case '/':
			System.out.println("i1/i2 = "+(i1/i2));break;
		case '%':
			System.out.println("i1%i2 = "+(i1%i2));break;
		default:
			System.out.println("유효하지 않는 연산자입니다");	break;
		}
	}
}















