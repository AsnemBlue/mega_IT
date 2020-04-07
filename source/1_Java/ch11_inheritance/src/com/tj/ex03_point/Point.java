package com.tj.ex03_point;
public class Point {
	private int x;
	private int y;
	public void pointPrint() {
		System.out.println("2Â÷¿ø ÁÂÇ¥ : "+x+", "+y);
	}
	public String pointInfoString() {
		return "2Â÷¿ø ÁÂÇ¥ : "+x+", "+y;
	}
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
}
