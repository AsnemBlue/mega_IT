package com.tj.ex4_object;
public class Point3D implements Cloneable{
	private double x;
	private double y;
	private double z;
	public Point3D() {  }
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return "ÁÂÇ¥°ª [" + x + ", " + y + ", " + z + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Point3D) {
			boolean xChk = this.x == ((Point3D)obj).x;
			boolean yChk = this.y == ((Point3D)obj).y;
			boolean zChk = this.z == ((Point3D)obj).z;
			return xChk && yChk && zChk;
		}else {
			return false;
		}//if
	}//equals
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
