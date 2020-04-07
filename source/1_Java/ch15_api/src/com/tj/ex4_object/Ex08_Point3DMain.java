package com.tj.ex4_object;

public class Ex08_Point3DMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		Point3D p2 = new Point3D(1.1, 2.4, 3);
		Point3D p3 = (Point3D) p2.clone();
		System.out.println("p1 "+p1);
		System.out.println("p1 "+p2);
		System.out.println("p1 "+p3);
		System.out.println("p1의 해쉬코드 : "+p1.hashCode());
		System.out.println("p2의 해쉬코드 : "+p2.hashCode());
		System.out.println("p3의 해쉬코드 : "+p3.hashCode());
		System.out.println("p2.equals(p3) : "+p2.equals(p3));
		System.out.println("p2 == p3 : " + (p2==p3) +"그러므로 복제됨");
	}
}
