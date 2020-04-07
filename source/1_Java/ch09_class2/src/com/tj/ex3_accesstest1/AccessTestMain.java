package com.tj.ex3_accesstest1;
public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		// System.out.println(obj.privateMember);
		// obj.privateMethod();
		System.out.println(obj.defaultMember);
		obj.defaultMethod();//default:같은패키지내 접근허용
		System.out.println(obj.protectedMember);
		obj.protectedMethod();//같은패키지거나 상속받았거나
		System.out.println(obj.publicMember);
		obj.publicMethod(); // 접근제한 없음
	}
}
