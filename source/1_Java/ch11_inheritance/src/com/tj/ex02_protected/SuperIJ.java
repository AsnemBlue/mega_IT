package com.tj.ex02_protected;
public class SuperIJ {
	private int i;
	private int j;
	public void setIJ(int i, int j) {
		this.i = i; this.j=j;
	}
	protected int getI() {
		return i;
	}
	protected int getJ() {
		return j;
	}
}
