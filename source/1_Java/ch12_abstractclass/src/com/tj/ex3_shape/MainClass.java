package com.tj.ex3_shape;

public class MainClass {
	public static void main(String[] args) {
		Shape[] spape = {new Circle(5), new Triangle(10, 5), new Rectangle(5, 3)};
		for(Shape s : spape) {
			System.out.println("Circle ≥–¿Ã : "+s.computeArea());
			s.draw();
		}
	}
}
