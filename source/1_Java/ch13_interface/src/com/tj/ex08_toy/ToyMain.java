package com.tj.ex08_toy;
public class ToyMain {
	public static void main(String[] args) {
//		PoohToy pooh2 = new PoohToy();
//		MazingerToy mazinger2 = new MazingerToy();
//		AirPlaneToy airplane = new AirPlaneToy();
		
		IToy pooh = new PoohToy();
		IToy mazinger = new MazingerToy();
		IToy airPlane = new AirPlaneToy();
		IToy[] toy = {pooh, mazinger, airPlane};
		for(IToy t : toy) {
			System.out.println(t.getClass().getName());
		}
	}
}
