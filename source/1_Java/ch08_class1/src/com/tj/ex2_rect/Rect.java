package com.tj.ex2_rect;
public class Rect {
	private int width;
	private int height;
	public Rect() {} // 디폴트생성자
	public Rect(int s) {width = height = s;}
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public int area() {return width*height;}
	public int getWidth() {	return width;}
	public int getHeight() {return height;}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
