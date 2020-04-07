package com.tj.ex12_final;

public class MainClass {
	public static void main(String[] args) {
		Animal[] animal = {new Dog(), new Rabbit()};
		animal[0].running();
		animal[1].running();
		animal[1].stop();
		for(Animal a : animal) {
			a.running();
			a.running();
			a.stop();
		}//for
	}//main
}//class
