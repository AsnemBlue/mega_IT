package com.tj.ex03_point;
public class PointMain {
	public static void main(String[] args) {
		Point point = new Point();
		point.setX(10); point.setY(5);
		Point3D point3d = new Point3D();
		point3d.setX(10); point3d.setY(5);
		point3d.setZ(2);
		point.pointPrint();
		System.out.println(point.pointInfoString());
		point3d.point3DPrint();
		System.out.println(point3d.point3DInfoString());
	}
}
