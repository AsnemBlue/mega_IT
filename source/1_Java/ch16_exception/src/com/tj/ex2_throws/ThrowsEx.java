package com.tj.ex2_throws;
public class ThrowsEx {
	public ThrowsEx() throws Exception{	
		actionC();	
	}
	private void actionC() throws ArrayIndexOutOfBoundsException{
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}
	private void actionB() throws ArrayIndexOutOfBoundsException{
		System.out.println("actionB 전반부");
		actionA();
		System.out.println("actionB 후반부");
	}
	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA 전반부");
		int[] iArr = {0,1,2,3};
		System.out.println("iArr[4] = "+iArr[4]);
		//ArrayIndexOutOfBoundsException
		System.out.println("actionA 후반부");
	}
}
