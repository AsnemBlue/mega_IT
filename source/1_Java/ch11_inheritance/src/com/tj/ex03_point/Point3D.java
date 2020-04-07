package com.tj.ex03_point;

public class Point3D extends Point{
	private int z;
	public void point3DPrint() {
		System.out.println("3Â÷¿ø ÁÂÇ¥ : "+getX()
			+", "+getY()+", "+z);
	}
	public String point3DInfoString() {
		return "3Â÷¿ø ÁÂÇ¥ : "+getX()
					+", "+getY()+", "+z;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
