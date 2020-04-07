package com.tj.ex4_object;
public class Ex07_getClassGetSuperClass {
	public static void main(String[] args) {
		Rectangle obj = new Rectangle(10, 5, "∞À¡§");
		Class cls = obj.getClass();
		System.out.println(cls.getName()); // com.tj.ex4_object.Rectangle
		String name = cls.getName();
		System.out.println(name.substring(name.lastIndexOf(".")+1));// Rectangle
		Class superCls = obj.getClass().getSuperclass();
		System.out.println(superCls.getName());
	}
}