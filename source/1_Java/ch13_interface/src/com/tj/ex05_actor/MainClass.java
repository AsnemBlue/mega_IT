package com.tj.ex05_actor;
public class MainClass {
	public static void main(String[] args) {
		Actor park = new Actor("¹Úº¸°Ë");
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		park.canCatchCriminal();
		park.canSearch();
		FireFighter firePark = park;
		firePark.outFire();
		firePark.saveMan();
//		firePark.makePizza();
//		firePark.makeSpaghetti();
//		firePark.canCatchCriminal();
//		firePark.canSearch();
		Chef chefPark = park;
		//chefPark.outFire();
		//chefPark.saveMan();
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		//chefPark.canCatchCriminal();
		//chefPark.canSearch();
		PoliceMan policePark = park;
//		policePark.outFire();
//		policePark.saveMan();
//		policePark.makePizza();
//		policePark.makeSpaghetti();
		policePark.canCatchCriminal();
		policePark.canSearch();
	}
}
